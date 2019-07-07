package ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Rewards {
    private final List<Reward> rewards;

    private Rewards(List<String> rewards) {
        this.rewards = rewards.stream()
                .map(Reward::new)
                .collect(Collectors.toList());
    }

    public static Rewards of(String rewardString) {
        List<String> rewards = Arrays.asList(rewardString.split(","));
        return new Rewards(rewards);
    }

    public List<Reward> getRewards() {
        return Collections.unmodifiableList(rewards);
    }
}
