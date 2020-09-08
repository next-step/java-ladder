package ladder.domain.reward;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RewardTest {
    @Test
    void create() {
        Reward reward = Reward.of("꽝");
        assertThat(reward).isEqualTo(Reward.of("꽝"));
    }
}