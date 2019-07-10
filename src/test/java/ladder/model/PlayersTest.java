package ladder.model;

import ladder.util.MockPlayersGenerator;
import ladder.util.MockRewardsGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class PlayersTest {

    @Test
    void takeReward() {
        Players players = MockPlayersGenerator.of("kim", "park", "lee");
        Rewards rewards = MockRewardsGenerator.of("3000", "4000", "2000");

        assertThat(players.takeReward(rewards.getReward(0))).isEqualTo(1);
    }
}
