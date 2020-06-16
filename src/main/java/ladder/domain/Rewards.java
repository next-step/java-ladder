package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Rewards {
    private final List<Reward> rewards;

    public Rewards(List<String> rewards) {
        this.rewards = createRewards(rewards);
    }

    private List<Reward> createRewards(List<String> rewards) {
        return rewards.stream()
                .map(Reward::new)
                .collect(Collectors.toList());
    }

    public List<Reward> getRewards() {
        return rewards;
    }
}
