package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RewardTest {
    @Test
    @DisplayName("주어진 String 으로 생성된다")
    void constructor() {
        Reward reward = new Reward("꽝");

        assertThat(reward.getName()).isEqualTo("꽝");
    }
}
