package ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LadderRewards {
    private static final String REWARD_SEPARATOR = ",";
    private List<LadderReward> ladderRewards;

    public static LadderRewards of(String rewards) {
        return new LadderRewards(Arrays.stream(rewards.split(REWARD_SEPARATOR))
                .map(LadderReward::new)
                .collect(Collectors.toList()));
    }

    private LadderRewards(List<LadderReward> ladderRewards) {
        this.ladderRewards = Collections.unmodifiableList(ladderRewards);
    }

    public LadderReward getReward(Position position) {
        return ladderRewards.get(position.getPosition());
    }

    public List<String> getLadderRewards() {
        return ladderRewards.stream()
                .map(LadderReward::toString)
                .collect(Collectors.toList());
    }
}
