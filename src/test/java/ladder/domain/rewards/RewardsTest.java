package ladder.domain.rewards;

import ladder.domain.players.Players;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RewardsTest {
    private Players players;

    @Before
    public void setUp() throws Exception {
        players = Players.generate("a, b, c");
    }

    @Test(expected = IllegalArgumentException.class)
    public void 플레이어_수와_보상수_안맞으면_에러() {
        Rewards rewards = Rewards.generate("꽝", players);
    }

    @Test
    public void 보상아이템_생성() {
        Rewards rewards = Rewards.generate("1등,2등,3등", players);

        assertThat(rewards.size()).isEqualTo(3);

    }

    @Test
    public void 보상아이템_생성시_trim() {
        Rewards rewards = Rewards.generate("1등 , 2등 , 3등", players);

        assertThat(rewards.size()).isEqualTo(3);
    }
}
