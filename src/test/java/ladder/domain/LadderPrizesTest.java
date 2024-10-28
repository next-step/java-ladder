package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class LadderPrizesTest {
    @Test
    void 결과들_생성() {
        LadderPrizes ladderPrizes = new LadderPrizes(List.of(new LadderPrize("꽝"), new LadderPrize("3000")));
        assertThat(ladderPrizes).isNotNull();
    }
}
