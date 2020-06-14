package ladder.domain.reward;

import ladder.domain.game.LadderReward;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderRewardTest {

    @Test
    @DisplayName("사다리 타기 게임 상금 입력 성공")
    void LadderRewardInputReward_Success() {
        LadderReward ladderReward = LadderReward.inputReward("꽝");
        assertThat(ladderReward.getReward()).isEqualTo("꽝");
    }

    @Test
    @DisplayName("사다리 타기 게임 상금 입력 실패")
    void LadderRewardInputReward_Fail() {
        assertThatThrownBy(() -> LadderReward.inputReward(""))
                .hasMessageMatching("유요하지 않은 경품을 입력했습니다.");
    }


}