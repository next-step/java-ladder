package camp.nextstep.edu.rebellion.domain.reward;

import camp.nextstep.edu.rebellion.domain.reward.Reward;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RewardTest {
    @DisplayName("당첨결과 한 개가 잘 생성 되는지 확인")
    @Test
    public void rewardTest() {
        // given
        String name = "1등";

        // when
        Reward reward = new Reward(name);

        // then
        assertThat(reward.getName()).isEqualTo(name);
    }

    @DisplayName("이름이 없을 경우 예외 발생")
    @Test
    public void rewardThrownTest() {
        // given
        String name = "";

        // when & then
        assertThatThrownBy(() -> new Reward(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨결과 이름이 없습니다");
    }
}
