package my.project.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Rewards {
    public static final String DELIMITER = ",";

    private List<Reward> rewards;

    public Rewards(String rewards) {
        this.rewards = parseRewards(rewards);
    }

    private List<Reward> parseRewards(String rewards) {
        return Arrays.stream(rewards.split(DELIMITER))
                .map(Reward::new)
                .collect(Collectors.toList());
    }

    public List<Reward> getRewards() {
        return rewards;
    }
}
