package ladder;

import ladder.model.Reward;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThat;

public class RewardTest {
    @DisplayName("게임 결과는 꽝 또는 양수만 허용한다")
    @ParameterizedTest
    @ValueSource(strings = {"꽝", "1000", "3000", "5000"})
    void create(String input) {
        Reward reward = new Reward(input);
        assertThat(reward.getReward()).isEqualTo(input);
    }

    @DisplayName("게임 결과가 꽝 또는 양수가 아닌 경우 에외가 발생한다")
    @Test
    void createFail() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Reward("FAIL"));
    }

    @DisplayName("같은 Reward 비교 시 참을 리턴한다")
    @Test
    void equals() {
        Reward reward1 = new Reward("1000");
        Reward reward2 = new Reward("1000");

        assertThat(reward1).isEqualTo(reward2);
    }
}
