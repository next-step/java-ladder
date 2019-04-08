package ladder.domain.reward;

import ladder.vo.coordinate.CoordinateValue;

import java.util.List;

public class Rewards {
    private static final int MIN_REWARDS_SIZE = 2;

    private final List<Reward> rewards;

    public Rewards(List<Reward> rewards) {
        validateRewards(rewards);

        this.rewards = rewards;
    }

    private void validateRewards(List<Reward> rewards) {
        if (rewards.size() < MIN_REWARDS_SIZE) {
            throw new IllegalArgumentException("The number of rewards must be at least " + MIN_REWARDS_SIZE);
        }
    }

    public int getNumberOfRewards() {
        return this.rewards.size();
    }

    public Reward getReward(CoordinateValue x) {
        return this.rewards.get(x.getValue());
    }
}
