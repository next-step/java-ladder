package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Rewards {
    private final List<Reward> rewards;

    public Rewards(List<String> rewards, int countOfPlayers) {
        validateRewardsCount(rewards, countOfPlayers);
        this.rewards = createRewards(rewards);
    }

    private void validateRewardsCount(List<String> rewards, int countOfPlayers) {
        if (rewards.size() != countOfPlayers) {
            throw new RewardsCountException();
        }
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
