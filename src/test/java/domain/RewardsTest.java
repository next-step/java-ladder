package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RewardsTest {

    @Test
    public void 사다리_결과_생성() {
        Rewards rewards = Rewards.fromInput("꽝,꽝,5000,4000");

        assertThat(rewards.get(0)).isEqualTo("꽝");
        assertThat(rewards.get(3)).isEqualTo("4000");
    }
}