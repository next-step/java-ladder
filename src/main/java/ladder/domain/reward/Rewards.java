package ladder.domain.reward;

import java.util.List;
import java.util.stream.Collectors;

public class Rewards {
    private final List<Reward> rewards;

    public Rewards(List<Reward> rewards) {
        validate(rewards);
        this.rewards = rewards;
    }

    private void validate(List<Reward> rewards) {
        if (rewards == null || rewards.isEmpty()) {
            throw new IllegalArgumentException("rewards는 빈 값 일 수 없습니다.");
        }
    }

    public boolean isSameNumbers(int playerSize) {
        return rewards.size() == playerSize;
    }

    public static Rewards from(List<String> rewardNames) {
        return new Rewards(
                rewardNames.stream()
                        .map(Reward::new)
                        .collect(Collectors.toList())
        );
    }

    @Override
    public String toString() {
        return rewards.stream()
                .map(Reward::toString)
                .collect(Collectors.joining());
    }
}
