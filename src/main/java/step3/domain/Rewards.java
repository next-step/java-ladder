package step3.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Rewards {

    private final List<Reward> rewards;

    private Rewards(List<Reward> rewards) {
        this.rewards = rewards;
    }

    public static Rewards of(List<String> rewards) {
        return new Rewards(toReward(rewards));
    }

    public static List<Reward> toReward(List<String> reward) {
        return reward.stream()
                .map(Reward::of)
                .collect(Collectors.toList());
    }

    public List<Reward> getRewards() {
        return rewards;
    }

    public String getReward(int position) {
        return this.rewards.get(position).getName();
    }
}
