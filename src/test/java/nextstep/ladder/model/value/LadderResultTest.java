package nextstep.ladder.model.value;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderResultTest {

    @Test
    @DisplayName("사다리 결과를 가지는 객체 생성 검증")
    void createTest() {
        LadderResult result = new LadderResult("꽝");

        assertThat(result).isEqualTo(new LadderResult("꽝"));
    }
}
