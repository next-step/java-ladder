package ladder.domain;

import ladder.util.StringUtils;

import java.util.List;

public class Reward {

    private final List<String> rewards;

    public Reward(String rewardStr) {
        rewards = StringUtils.splitStringToList(rewardStr);
    }

    public List<String> getRewards() {
        return rewards;
    }

    public String getReward(int rewardIndex) {
        return rewards.get(rewardIndex);
    }
}
