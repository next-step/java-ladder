package ladder.domain.reward;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RewardsTest {

    @DisplayName("Rewards 생성 테스트")
    @Test
    void createTest() {
        Rewards rewards = Rewards.of(Arrays.asList(new Reward("꽝")), 1);
        assertThat(rewards).isEqualTo(Rewards.of(Arrays.asList(new Reward("꽝")), 1));
    }

    @DisplayName("Rewards 생성 테스트")
    @Test
    void createOfPrizesTest() {
        Rewards rewards = Rewards.ofPrizes("꽝,5000,꽝,3000", 4);
        assertThat(rewards).isEqualTo(Rewards.ofPrizes("꽝,5000,꽝,3000", 4));
    }

    @DisplayName("Rewards 생성 예외처리 테스트")
    @Test
    void create_invalidCount() {
        assertThatThrownBy(() -> Rewards.ofPrizes("꽝,5000,꽝,3000", 5))
                .isInstanceOf(IllegalArgumentException.class);
    }
}