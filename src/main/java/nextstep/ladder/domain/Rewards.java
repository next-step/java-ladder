package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Rewards {
    private final List<Reward> rewards;

    public Rewards(List<Reward> rewards) {
        this.rewards = rewards;
    }

    public static Rewards ofByRaw(String rewardsRaw) {
        String[] splitRewardsRaw = rewardsRaw.split(",");
        List<Reward> rewards = new ArrayList<>();
        for (String rewardRaw : splitRewardsRaw) {
            Reward result = new Reward(rewardRaw.trim());
            rewards.add(result);
        }
        return new Rewards(rewards);
    }

    public List<Reward> getRewards() {
        return rewards;
    }

    public Reward findByIdx(int idx) {
        if (rewards.size() == 1) {
            return rewards.get(0);
        }
        return rewards.get(idx);
    }
}
