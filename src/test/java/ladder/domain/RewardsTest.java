package ladder.domain;

import org.junit.jupiter.api.Test;

public class RewardsTest {
    @Test
    void constructor() {
        Rewards rewards = Rewards.of("꽝,3000");

        assertThat(rewards.getRewards()).contains(
                new Rewards("꽝"),
                new Rewards("3000")
        );
    }
}
