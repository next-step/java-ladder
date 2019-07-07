package ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rewards rewards1 = (Rewards) o;
        return Objects.equals(rewards, rewards1.rewards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rewards);
    }
}
