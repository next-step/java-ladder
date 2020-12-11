package domain;

import java.util.Arrays;
import java.util.List;

import static common.DelimiterConstants.SPLIT_DELIMITER;

public class Rewards {
    private final List<String> rewards;

    private Rewards(final List<String> rewards) {
        this.rewards = rewards;
    }

    public static Rewards of(final String commaSeparatedRewards) {
        String[] rewards = commaSeparatedRewards.split(SPLIT_DELIMITER);

        return new Rewards(Arrays.asList(rewards));
    }

    public List<String> getRewards() {
        return rewards;
    }

    public int size() {
        return rewards.size();
    }

    public String getRewardAt(final int index) {
        return rewards.get(index);
    }
}
