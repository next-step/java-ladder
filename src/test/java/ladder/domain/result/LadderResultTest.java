package ladder.domain.result;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderResultTest {

    @DisplayName("LadderResult 생성 테스트")
    @Test
    void createTest() {
        LadderResult result = LadderResult.of("pobi", "꽝");
        assertThat(result).isEqualTo(LadderResult.of("pobi", "꽝"));
    }
}