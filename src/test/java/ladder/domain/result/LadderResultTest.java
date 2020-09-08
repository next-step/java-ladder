package ladder.domain.result;

import ladder.domain.player.Player;
import ladder.domain.reward.Reward;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderResultTest {

    @Test
    void create() {
        LadderResult result = LadderResult.of(Player.of("pobi"), Reward.of("꽝"));
        assertThat(result).isEqualTo(LadderResult.of(Player.of("pobi"), Reward.of("꽝")));
    }
}