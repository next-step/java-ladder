package ladder.domain.reward;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RewardTest {

    @DisplayName("Reward 생성 테스트")
    @Test
    void createTest() {
        Reward reward = new Reward("꽝");
        assertThat(reward).isEqualTo(new Reward("꽝"));
    }
}