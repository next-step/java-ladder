package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class LadderResultTest {
    @Test
    void 결과_생성() {
        LadderResult ladderResult = new LadderResult("꽝");
        assertThat(ladderResult).isNotNull();
    }

    @Test
    void 결과값_검증(){
        assertThatThrownBy(() -> new LadderResult(""))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
