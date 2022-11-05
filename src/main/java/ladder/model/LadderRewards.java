package ladder.model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LadderRewards {

    private List<Reward> rewards;

    private LadderRewards(List<Reward> rewards) {
        this.rewards = rewards;
    }

    public static LadderRewards of(String[] values) {
        List<Reward> rewards = Arrays.stream(values)
                .map(Reward::new)
                .collect(Collectors.toList());

        return new LadderRewards(rewards);
    }

    public Reward get(int index) {
        return rewards.get(index);
    }

    public LadderRewards getRewardsByRank(List<Integer> result) {
        List<Reward> mappedRewards = result.stream()
                .map(rewards::get)
                .collect(Collectors.toList());

        return new LadderRewards(mappedRewards);
    }

    public List<Reward> getRewards() {
        return rewards;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderRewards that = (LadderRewards) o;
        return Objects.equals(rewards, that.rewards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rewards);
    }
}
