package ladderGame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LadderResultsTest {

    @Test
    @DisplayName("결과들과 포지션에 맞는 결과 찾기")
    void getResult() {
        LadderResults ladderResults = LadderResults.of(Arrays.asList("1000", "2000", "3000", "꽝"));
        Result result = ladderResults.getResult(new Position(1));
        assertThat(result.getContent()).isEqualTo("2000");
    }
}