package nextstep.ladder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Rewards {
    private final List<String> rewards;

    private Rewards(List<String> rewards) {
        this.rewards = rewards;
    }

    public static Rewards of(String[] rewardNames) {
        return new Rewards(Arrays.asList(rewardNames));
    }

    public int count() {
        return this.rewards.size();
    }

    public List<String> getRewards() {
        return rewards;
    }

    public String getRewardByIndex(int index) {
        return this.rewards.get(index);
    }
}
