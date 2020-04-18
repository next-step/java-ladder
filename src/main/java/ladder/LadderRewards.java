package ladder;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LadderRewards {
    private static final String REWARD_SEPARATOR = ",";
    private final List<LadderReward> ladderRewards;

    public static LadderRewards of(String rewards) {
        return new LadderRewards(Arrays.stream(rewards.split(REWARD_SEPARATOR))
                .map(LadderReward::new)
                .collect(Collectors.toList()));
    }

    public LadderRewards(List<LadderReward> ladderRewards) {
        this.ladderRewards = ladderRewards;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LadderRewards)) return false;
        LadderRewards that = (LadderRewards) o;
        return Objects.equals(ladderRewards, that.ladderRewards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladderRewards);
    }
}
