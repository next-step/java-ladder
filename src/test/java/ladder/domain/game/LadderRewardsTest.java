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
                .hasMessageMatching("보상을 빈칸 혹은 null 로 입력하였습니다.");
    }

    @Test
    void LadderRewards_보상_GET_FAIL_Test() {
        String[] rewards = {"1000", "10", "10000", "1"};
        LadderRewards ladderRewards = LadderRewards.inputRewards(rewards);
        assertThatThrownBy(() -> ladderRewards.getLadderReward(new Position(5)))
                .hasMessageMatching("유효하지 않은 position 을 입력했습니다.");
    }

}