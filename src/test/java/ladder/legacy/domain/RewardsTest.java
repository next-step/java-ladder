package ladder.legacy.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RewardsTest {

    @Test
    void rewards_creation_test() {
        String input = "꽝,5000,꽝,3000";

        Rewards rewards = Rewards.of(input);

        String[] values = input.split(",");
        for (int i = 0; i < values.length; ++i) {
            assertThat(rewards.getRewardByPosition(i))
                    .isEqualTo(values[i]);
        }
    }

    @Test
    void rewards_exception_tes() {
        String input = "";
        assertThatThrownBy(() -> Rewards.of(input))
                .isInstanceOf(NullPointerException.class);

        assertThatThrownBy(() -> Rewards.of(null))
                .isInstanceOf(NullPointerException.class);
    }
}