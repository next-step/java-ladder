package nextstep.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("사다리 결과")
public class LadderResultTest {

    @DisplayName("생성")
    @Test
    public void create() {
        LadderResult ladderResult = new LadderResult("꽝");
        assertThat(ladderResult.getResult()).isEqualTo("꽝");
    }

}
