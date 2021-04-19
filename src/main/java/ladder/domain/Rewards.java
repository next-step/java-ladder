package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Rewards {
    private final List<Reward> rewards;

    public Rewards(List<Reward> rewards) {
        this.rewards = rewards;
    }

    public static Rewards valueOf(List<String> stringRewards) {
        return new Rewards(stringRewards.stream()
                .map(stringReward -> new Reward(stringReward))
                .collect(Collectors.toList()));
    }

    public Reward getReward(int index) {
        return this.rewards.get(index);
    }
}
