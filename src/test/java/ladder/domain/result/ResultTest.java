package ladder.domain.result;

import ladder.domain.player.Player;
import ladder.domain.reward.Reward;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ResultTest {
    @Test
    void Result는_player_없이_생성_할_경우_예외를_발생_시킨다() {
        assertThatThrownBy(
                () -> new Result(null, new Reward("name", 0))
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void Result는_reward_없이_생성_할_경우_예외를_발생_시킨다() {
        assertThatThrownBy(
                () -> new Result(new Player("name", 0), null)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
