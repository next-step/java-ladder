package ladder.domain.reward;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class RewardsTest {
    @Test
    public void 경품이_2개_미만일_경우_IllegalArgumentException() {
        // given
        Reward reward = new Reward("1000");

        // when
        // then
        assertThatIllegalArgumentException().isThrownBy(() -> new Rewards(Arrays.asList(reward)));
    }
}
