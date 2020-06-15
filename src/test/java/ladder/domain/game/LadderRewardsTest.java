package ladder.domain.game;

import ladder.domain.ladder.Position;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderRewardsTest {

    @Test
    void LadderRewardsCreateTest() {
        String[] rewards = {"1000", "10", "10000", "1"};
        LadderRewards ladderRewards = LadderRewards.inputRewards(rewards);
        LadderReward ladderReward = ladderRewards.getLadderReward(new Position(1));
        String reward = ladderReward.getReward();

        assertThat(reward).isEqualTo("10");
    }

    @Test
    void LadderRewardsCreate_Fail_Test() {
        String[] rewards = null;
        assertThatThrownBy(() ->LadderRewards.inputRewards(rewards))
                .hasMessageMatching("실행 결과를 입력하세요");
    }

}