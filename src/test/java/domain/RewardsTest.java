package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RewardsTest {

    public static final Rewards DEFAULT_REWARDS = Rewards.from("good,bad,good");

    @Test
    public void 생성() {
        Rewards rewards = Rewards.from("good,bad");

        assertThat(rewards.size()).isEqualTo(2);
    }
}