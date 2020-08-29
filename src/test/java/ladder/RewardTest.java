package ladder;

import ladder.domain.Reward;
import ladder.util.StringUtils;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RewardTest {

    @Test
    public void rewardTest() {

        String rewardStr = "a,b,c";
        Reward reward = new Reward(rewardStr);

        List<String> rewards = reward.getRewards();
        List<String> rewardsFromRewardStr = StringUtils.splitStringToList(rewardStr);

        assertEquals(rewards, rewardsFromRewardStr);
        assertEquals(reward.getReward(0), "a");
        assertEquals(reward.getReward(1), "b");
        assertEquals(reward.getReward(2), "c");
    }
}
