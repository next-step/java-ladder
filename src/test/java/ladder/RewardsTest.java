package ladder;

import ladder.domain.Reward;
import ladder.domain.Rewards;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RewardsTest {

    private Reward reward;
    private Rewards rewards;

    @Test
    @DisplayName("사용자 수와 결과 수 다른지")
    public void userAndReward() {
        assertThatThrownBy(() -> new Rewards("1,2,3,4", 3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사용자의 수와 결과의 수가 다릅니다.");
    }

    @BeforeEach
    void setup() {
        reward = new Reward(0, "1000");
        rewards = new Rewards("1000", 1);
    }

    @ParameterizedTest
    @ValueSource(strings = "1000")
    @DisplayName("같은 포지션의 상을 제대로 불러오는지")
    public void getSamePosition(String input) {
        assertThat(rewards.getSamePosition(0).getReward()).isEqualTo(input);
    }
}
