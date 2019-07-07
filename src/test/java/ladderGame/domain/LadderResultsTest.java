package ladderGame.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LadderResultsTest {

    private LadderResults ladderResults;

    @BeforeEach
    void setUp() {

        ladderResults = LadderResults.of(Arrays.asList("1000", "2000", "3000", "꽝"));
    }

    @Test
    @DisplayName("결과들과 포지션에 맞는 결과 찾기")
    void getResult() {
        assertThat(ladderResults.getResult(new Position(1))).isEqualTo("2000");
    }

    @Test
    @DisplayName("없는 범위의 Position 예외처리")
    void getResultException() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            ladderResults.getResult(new Position(5));
        });
    }
}