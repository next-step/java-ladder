package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LadderResultTest {
    @Test
    @DisplayName("전체 사다리 타기 실행 결과를 얻는다")
    void getLadderResult() {
        LadderResult result = new LadderResult(Map.of("red", "300", "green", "200"));
        assertThat(result.getResult()).isEqualTo(Map.of("red", "300", "green", "200"));
    }

    @Test
    @DisplayName("특정 이름에 대한 사다리 타기 실행 결과를 얻는다")
    void getLadderResultByName() {
        LadderResult result = new LadderResult(Map.of("red", "300", "green", "200"));
        assertThat(result.getResult("red")).isEqualTo("300");
        assertThat(result.getResult("green")).isEqualTo("200");
    }
}
