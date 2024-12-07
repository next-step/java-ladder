package ladder.domain.ns;

import ladder.domain.interfaces.Rewards;
import ladder.exception.RewardsCountException;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class NsRewards implements Rewards {
    public static final String DELIMITER = ",";
    public static final String PLAYERS_COUNT_REWARDS_COUNT_NOT_EQUAL_MESSAGE = "players 갯수와 rewards 갯수는 일치해야 합니다.";
    private final List<RewardName> rewardNames;

    public NsRewards(List<RewardName> rewardNames, int playersCount) {
        if (playersCount != rewardNames.size()) {
            throw new RewardsCountException(PLAYERS_COUNT_REWARDS_COUNT_NOT_EQUAL_MESSAGE);
        }
        this.rewardNames = rewardNames;
    }

    public NsRewards(String rewards, int playersCount) {
        this(toRewardNames(rewards), playersCount);
    }

    private static List<RewardName> toRewardNames(String rewards) {
        return Arrays.stream(rewards.split(DELIMITER))
                .map(value -> new RewardName(value.trim()))
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public List<RewardName> names() {
        return rewardNames;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NsRewards rewards = (NsRewards) o;
        return Objects.equals(rewardNames, rewards.rewardNames);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rewardNames);
    }
}
