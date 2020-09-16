package ladder;

import ladder.domain.Reward;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RewardTest {

    private Reward reward;

    @BeforeEach
    void setup() {
        reward = new Reward(0, "3000");
    }

    @DisplayName("상품을 가져오는지")
    @Test
    public void getReward() {
        assertThat(reward.getReward()).isEqualTo("3000");
    }

    @DisplayName("위치값을 가져오는지")
    @Test
    public void getPosition() {
        assertThat(reward.equalPosition(0)).isTrue();
        assertThat(reward.equalPosition(1)).isFalse();
    }
}
