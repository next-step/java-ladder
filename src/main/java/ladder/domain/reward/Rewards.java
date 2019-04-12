package ladder.domain.reward;

import java.util.List;
import java.util.stream.Collectors;

public class Rewards {
    private static final int MIN_REWARDS_SIZE = 2;
    private static final String WHITE_SPACE = " ";

    private final List<Reward> rewards;

    public Rewards(List<Reward> rewards) {
        validateRewards(rewards);

        this.rewards = rewards;
    }

    public int getNumberOfRewards() {
        return this.rewards.size();
    }

    public Reward getReward(int index) {
        return this.rewards.get(index);
    }

    private void validateRewards(List<Reward> rewards) {
        if (rewards.size() < MIN_REWARDS_SIZE) {
            throw new IllegalArgumentException("The number of rewards must be at least " + MIN_REWARDS_SIZE);
        }
    }

    @Override
    public String toString() {
        return this.rewards.stream()
                .map(Reward::toFormedString)
                .collect(Collectors.joining(WHITE_SPACE));
    }
}
