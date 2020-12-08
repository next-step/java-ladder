package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class GameRewardTest {

    @Test
    @DisplayName("사다리 게임결과 보상값 Index 별로 확인")
    void gameReward_reward_isEqualTo() {
        GameReward gameReward = GameReward.of("꽝,3000,4000,꽝");

        assertAll(
            () -> assertThat(gameReward.get(0)).isEqualTo("꽝"),
            () -> assertThat(gameReward.get(1)).isEqualTo("3000"),
            () -> assertThat(gameReward.get(2)).isEqualTo("4000"),
            () -> assertThat(gameReward.get(3)).isEqualTo("꽝")
        );
    }

    @Test
    @DisplayName("사다리 게임결과 보상값이 없을 시에 IllegalArgumentException 발생")
    void gameReward_emptyReward_throwIllegalArgumentException() {
        assertThatThrownBy(() -> GameReward.of(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("결과에 빈값을 입력 할 수 없습니다.");
    }
}
