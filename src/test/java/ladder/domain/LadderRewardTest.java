package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderRewardTest {
    private LadderReward reward;

    @BeforeEach
    void setUp() {
        reward = new LadderReward(Arrays.asList("100", "꽝", "10억"));
    }

    @Test
    void getReward() {
        String actual = reward.getReward(2);

        assertThat(actual).isEqualTo("10억");
    }

    @Test
    void sameSize() {
        assertThat(reward.sameSize(3)).isTrue();
        assertThat(reward.sameSize(4)).isFalse();
    }
}
