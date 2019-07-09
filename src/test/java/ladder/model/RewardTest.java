package ladder.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RewardTest {
    @Test
    @DisplayName("보상은 String으로 생성된다.")
    void new_WithString_Created() {
        final String rewardValue = "5000";
        final Reward reward = new Reward(rewardValue);
        assertThat(reward).isInstanceOf(Reward.class);
    }

    @Test
    @DisplayName("보상은 5자를 넘으면 예외가 발생한다.")
    void new_WithStringOver5Length_ExceptionThrown() {
        final String reward = "123456";
        assertThatThrownBy(() -> new Reward(reward))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
