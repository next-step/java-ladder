package step2.domain;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Collections.unmodifiableList;

public class Rewards {

    private final List<Reward> rewards;

    private Rewards(List<Reward> rewards) {
        this.rewards = rewards;
    }

    public static Rewards of(List<String> rewardsNames) {
        return new Rewards(rewardsNames.stream()
                .map(Reward::of)
                .collect(Collectors.toList()));
    }

    public List<Reward> getRewards() {
        return unmodifiableList(rewards);
    }

}
