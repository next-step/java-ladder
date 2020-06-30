package ladder.domain.result;

import ladder.domain.player.Name;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class RewardTest {

    @DisplayName("null 입력 예외 발생")
    @Test
    void createNull() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Reward.create(null));
    }

    @DisplayName("입력한 이름을 반환")
    @Test
    void getName() {
        Reward reward = Reward.create(Name.valueOf("ABC"));
        assertThat(reward.getName()).isEqualTo(Name.valueOf("ABC"));
    }
}
