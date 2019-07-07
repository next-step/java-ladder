package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RewardsTest {
    @Test
    void constructor() {
        Rewards rewards = Rewards.of("꽝,3000");

        assertThat(rewards.getRewards()).contains(
                new Reward("꽝"),
                new Reward("3000")
        );
    }
}
