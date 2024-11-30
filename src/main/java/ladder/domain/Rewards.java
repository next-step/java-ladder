package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Rewards {
    public static final String DELIMITER = ",";
    private final List<RewardName> rewardNames;

    public Rewards(List<RewardName> rewardNames) {
        this.rewardNames = rewardNames;
    }

    public Rewards(String rewards) {
        this(toRewardNames(rewards));
    }

    private static List<RewardName> toRewardNames(String rewards) {
        return Arrays.stream(rewards.split(DELIMITER))
                .map(value -> new RewardName(value.trim()))
                .collect(Collectors.toUnmodifiableList());
    }

    public List<RewardName> names() {
        return rewardNames;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rewards rewards = (Rewards) o;
        return Objects.equals(rewardNames, rewards.rewardNames);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rewardNames);
    }
}
