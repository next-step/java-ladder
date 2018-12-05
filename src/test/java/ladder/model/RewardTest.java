package ladder.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RewardTest {

    @Test
    public void 결과_입력() {
        Reward reward = Reward.of("3000");
        assertThat(reward).isEqualTo(Reward.of("3000"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 결과_5자_초과입력() {
        Reward.of("300000");
    }

    @Test(expected = IllegalArgumentException.class)
    public void 결과_1자_미만입력() {
        Reward.of("");
    }
}
