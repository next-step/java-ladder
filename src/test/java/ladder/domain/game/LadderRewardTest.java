package ladder.domain.game;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderRewardTest {

    @Test
    void LadderRewardCreateTest() {
        LadderReward ladderReward = LadderReward.inputReward("100");
        assertThat(ladderReward.getReward()).isEqualTo("100");
    }

    @Test
    void LadderRewardCreate_Fail_Test() {
        assertThatThrownBy(() -> LadderReward.inputReward(""))
                .hasMessageMatching("유요하지 않은 경품을 입력했습니다.");
    }

}