package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

class LadderResultTest {

    @DisplayName("참가자, 결과 형태의 map을 전달하면 LadderResult객체를 생성한다.")
    @Test
    void LadderResultTest() {
        Assertions.assertThat(new LadderResult(Map.of("참가자1", "꽝", "참가자2", "당첨")))
                .isInstanceOf(LadderResult.class);
    }
}
