package ladder.domain;

import ladder.util.StringUtils;

import java.util.List;

public class Reward {

    private List<String> rewards;

    public Reward(String rewardStr) {
        rewards = StringUtils.splitStringToList(rewardStr);
    }

    public List<String> getRewards() {
        return rewards;
    }
}
