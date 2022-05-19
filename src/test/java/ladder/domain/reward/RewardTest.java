package ladder.domain.reward;

import ladder.domain.player.Name;
import ladder.domain.point.Position;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RewardTest {
    public static final Reward REWARD_ZERO = new Reward("ZERO", 0);
    public static final Reward REWARD_ONE = new Reward("ONE", 1);

    @Test
    void Reward는_name_없이_생성_할_경우_예외를_발생_시킨다() {
        assertThatThrownBy(
                () -> new Reward((Name) null, new Position(0))
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void Reward는_position_없이_생성_할_경우_예외를_발생_시킨다() {
        assertThatThrownBy(
                () -> new Reward(Name.valueOf("name"), null)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
