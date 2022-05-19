package ladder.domain.reward;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RewardsTest {
    @ParameterizedTest
    @NullAndEmptySource
    void Rewards는_rewards_없이_생성_할_경우_예외를_발생_시킨다(List<Reward> rewards) {
        assertThatThrownBy(
                () -> new Rewards(rewards)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
