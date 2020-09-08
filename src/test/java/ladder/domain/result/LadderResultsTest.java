package ladder.domain.result;

import ladder.domain.player.Player;
import ladder.domain.reward.Reward;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LadderResultsTest {

    @Test
    void create() {
        LadderResults results = new LadderResults(Arrays.asList(LadderResult.of(Player.of("pobi"), Reward.of("꽝"))));

        assertThat(results.getLadderResults()).containsExactly(LadderResult.of(Player.of("pobi"), Reward.of("꽝")));
    }
}