package ladder.model;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RewardsTest {

    private String names;

    @Before
    public void setup() {
        names = "0,3000,0,3000";
    }

    @Test
    public void 결과_여러개_입력() {
        Rewards rewards = Rewards.of(names);

        assertThat(rewards).isEqualTo(Rewards.of(names));
        assertThat(rewards.count()).isEqualTo(4);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void 결과_미입력() {
        Rewards.of("");
    }
}
