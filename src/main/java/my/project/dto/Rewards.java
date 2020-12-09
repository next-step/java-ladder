package my.project.dto;

import my.project.domain.Reward;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Rewards {
    public static final String DELIMITER = ",";
    public static final int ARRAY_REWARDS_CONVERTER = 2;

    private final List<Reward> rewards;

    public Rewards(String rewards) {
        this.rewards = Arrays.stream(rewards.split(DELIMITER))
                .map(Reward::new)
                .collect(Collectors.toList());
    }

    public List<Reward> getRewards() {
        return rewards;
    }

    public Reward getReward(int resultIndex) {
        return rewards.get(resultIndex / ARRAY_REWARDS_CONVERTER);
    }
}
