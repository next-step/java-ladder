package step2.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Collections.unmodifiableList;

public class Rewards {


    private final List<Reward> rewards;

    private Rewards(List<Reward> rewards) {
        this.rewards = rewards;
    }

    public static Rewards of(List<String> rewardsNames) {
        return new Rewards(rewardsNames.stream()
                .map(Reward::of)
                .collect(Collectors.toList()));
    }

    public List<Reward> getRewards() {
        return unmodifiableList(rewards);
    }

    public String getRewardName(int position) {
        return rewards.get(position).getRewardName();
    }

    public int getRewardsCount() {
        return rewards.size();
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
