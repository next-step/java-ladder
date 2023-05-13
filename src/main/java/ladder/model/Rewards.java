package ladder.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Rewards {
    private final List<Reward> rewards;

    public Rewards(List<Reward> rewards) {
        this.rewards = rewards;
    }

    public static Rewards of(List<String> rewards) {
        return new Rewards(rewards.stream()
                .map(Reward::new)
                .collect(Collectors.toList()));
    }

    public List<Reward> getRewards() {
        return Collections.unmodifiableList(rewards);
    }
}
