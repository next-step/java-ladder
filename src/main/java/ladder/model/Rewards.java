package ladder.model;

import static java.util.stream.Collectors.toList;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Rewards {
    private static final int MINIMUM_NUMBER_OF_REWARDS = 2;
    private static final String MESSAGE_OF_MINIMUM_REWARDS = "보상의 갯수는 최소 %d 이상이어야 합니다.";

    private final List<Reward> rewards;

    public Rewards(List<String> rewards) {
        if (rewards.size() < MINIMUM_NUMBER_OF_REWARDS) {
            throw new IllegalArgumentException(
                    String.format(MESSAGE_OF_MINIMUM_REWARDS, MINIMUM_NUMBER_OF_REWARDS));
        }

        this.rewards = rewards.stream()
                              .map(Reward::new)
                              .collect(Collectors.collectingAndThen(toList(), Collections::unmodifiableList));
    }

    public List<Reward> getRewards() {
        return rewards;
    }

    public Reward getReward(int index) {
        return rewards.get(index);
    }
}