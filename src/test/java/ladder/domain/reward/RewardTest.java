package ladder.domain.reward;

import ladder.domain.reward.Reward;
import ladder.domain.reward.Rewards;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RewardTest {

    @Test
    @DisplayName("당첨결과 생성 되는지 확인")
    public void reward_test() {
        // given
        String name = "1등";

        // when
        Reward reward = Reward.of(name);

        // then
        assertThat(reward.getName()).isEqualTo(name);
    }

    @Test
    @DisplayName("잘못된 상금을 입력한 경우 예외발생 테스트")
    void reward_input_error_test() {
        assertThrows(IllegalArgumentException.class, () -> {
            Rewards.of(null);
            Rewards.of("");
        });
    }
}
