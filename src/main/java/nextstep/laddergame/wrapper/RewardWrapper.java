package nextstep.laddergame.wrapper;

import java.util.List;

public class RewardWrapper {
    private final List<String> rewards;

    public RewardWrapper(List<String> rewards) {
        this.rewards = rewards;
    }

    public List<String> getRewards() {
        return rewards;
    }

    public String getReward(int index) {
        return this.rewards.get(index);
    }
}
