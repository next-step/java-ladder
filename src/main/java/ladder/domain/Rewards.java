package ladder.domain;

import ladder.dto.RewardsDTO;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Rewards {

    private final List<Reward> rewards;

    public Rewards(List<?> rewards) {
        this.rewards = rewards.stream()
                .map(this::castToReward)
                .collect(Collectors.toList());
    }

    private Reward castToReward(Object o) {
        if (o instanceof String) {
            return new Reward((String) o);
        }
        return (Reward) o;
    }

    public Reward get(int index) {
        return rewards.get(index);
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

    public RewardsDTO exportData() {
        return rewards.stream()
                .map(Reward::getReward)
                .collect(collectingAndThen(toList(), RewardsDTO::new));
    }
}
