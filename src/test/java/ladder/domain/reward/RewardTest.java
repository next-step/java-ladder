package ladder.domain.reward;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class RewardTest {
    @Test
    public void 이름이_공백일_경우_IllegalArgumentException() {
        // given
        String reward = "  ";

        // when
        // then
        assertThatIllegalArgumentException().isThrownBy(() -> new Reward(reward));
    }

    @Test
    public void 이름이_5자를_초과할_경우_IllegalArgumentException() {
        // given
        String reward = "Galaxy";

        // when
        // then
        assertThatIllegalArgumentException().isThrownBy(() -> new Reward(reward));
    }
}
