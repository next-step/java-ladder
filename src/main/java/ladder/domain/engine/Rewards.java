package ladder.domain.engine;

import ladder.exception.RewardsCountException;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Rewards {
    public static final String DELIMITER = ",";
    public static final String PLAYERS_COUNT_REWARDS_COUNT_NOT_EQUAL_MESSAGE = "players 갯수와 rewards 갯수는 일치해야 합니다.";
    private final List<RewardName> rewardNames;

    public Rewards(List<RewardName> rewardNames, int playersCount) {
        if (playersCount != rewardNames.size()) {
            throw new RewardsCountException(PLAYERS_COUNT_REWARDS_COUNT_NOT_EQUAL_MESSAGE);
        }
        this.rewardNames = rewardNames;
    }

    public Rewards(String rewards, int playersCount) {
        this(toRewardNames(rewards), playersCount);
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
