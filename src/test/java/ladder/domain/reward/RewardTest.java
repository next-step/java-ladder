package ladder.domain.reward;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RewardTest {
    @Test
    void create() {
        Reward reward = new Reward("꽝");
        assertThat(reward).isEqualTo(new Reward("꽝"));
    }
}