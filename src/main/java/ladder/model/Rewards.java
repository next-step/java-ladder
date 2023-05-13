package ladder.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Rewards {
    private final List<Reward> rewards;

    public Rewards(List<Reward> rewards) {
        this.rewards = rewards;
    }

    public static Rewards of(int countOfUser, List<String> rewards) {
        if (rewards.size() != countOfUser) {
            throw new IllegalArgumentException("게임 결과는 참여자 수와 동일해야 합니다.");
        }

        return new Rewards(rewards.stream()
                .map(Reward::new)
                .collect(Collectors.toList()));
    }

    public List<Reward> getRewards() {
        return Collections.unmodifiableList(rewards);
    }
}
