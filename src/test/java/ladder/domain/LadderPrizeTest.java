package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class LadderPrizeTest {
    @Test
    void 결과_생성() {
        LadderPrize ladderResult = new LadderPrize("꽝");
        assertThat(ladderResult).isNotNull();
    }

    @Test
    void 결과값_검증(){
        assertThatThrownBy(() -> new LadderPrize(""))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
