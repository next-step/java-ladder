package ladder.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Rewards {
    private final List<Reward> rewards;

    public Rewards(List<Reward> rewards) {
        this.rewards = rewards;
    }

    public static Rewards valueOf(List<String> stringRewards) {
        return new Rewards(stringRewards.stream()
                .map(stringReward -> new Reward(stringReward))
                .collect(Collectors.toList()));
    }

    public Reward getReward(int index) {
        return this.rewards.get(index);
    }

    public List<Reward> rewards() {
        return this.rewards;
    }

    public String getAllReward() {
        StringBuilder sb = new StringBuilder();
        rewards.stream()
                .forEach(reward -> sb.append(reward.withWhiteSpaceReward()));
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Rewards rewards1 = (Rewards) o;
        return Objects.equals(rewards, rewards1.rewards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rewards);
    }

}
