package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LadderRewards {
    private final List<LadderReward> ladderRewards;

    public static LadderRewards of(final String rewardNames, final String separator) {
        return new LadderRewards(Stream.of(rewardNames.split(separator))
                .map(LadderReward::new)
                .collect(Collectors.toList()));
    }

    public LadderRewards(final List<LadderReward> ladderRewards) {
        this.ladderRewards = new ArrayList<>(ladderRewards);
    }

    public int size() {
        return ladderRewards.size();
    }

    public LadderReward getReward(Position rewardPosition) {
        return ladderRewards.get(rewardPosition.toInt());
    }

    public List<LadderReward> getRewards() {
        return new ArrayList<>(ladderRewards);
    }
}
