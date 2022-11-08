package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LadderResultsTest {

    @DisplayName("생성")
    @Test
    void create() {
        LadderResults ladderResults = new LadderResults(List.of(new LadderResult("꽝")));
        assertThat(ladderResults).isEqualTo(new LadderResults(List.of(new LadderResult("꽝"))));
    }

    @DisplayName("실패")
    @Test
    void invalid() {
        assertThatThrownBy(() -> new LadderResults(List.of()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("빈 사다리 결과는 생성될 수 없습니다.");
    }

    @DisplayName("사다리 결과 가져오기")
    @Test
    void get() {
        LadderResults ladderResults = new LadderResults(
                List.of(new LadderResult("1000"), new LadderResult("2000")));
        assertAll(
                () -> assertThat(ladderResults.get(0)).isEqualTo(new LadderResult("1000")),
                () -> assertThat(ladderResults.get(1)).isEqualTo(new LadderResult("2000"))
        );
    }
}
