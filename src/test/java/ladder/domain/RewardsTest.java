package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RewardsTest {
    @Test
    @DisplayName("String 이 Rewards 로 변환되어 생성된다")
    void constructor() {
        Rewards rewards = Rewards.of("꽝,3000");

        assertThat(rewards.getRewards()).containsExactly(
                new Reward("꽝"),
                new Reward("3000")
        );
    }
}
