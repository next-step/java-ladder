package ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LadderRewards {
    private static final String REWARD_SEPARATOR = ",";
    private List<String> ladderRewards;

    public static LadderRewards of(String rewards) {
        return new LadderRewards(Arrays.asList(rewards.split(REWARD_SEPARATOR)));
    }

    private LadderRewards(List<String> ladderRewards) {
        this.ladderRewards = Collections.unmodifiableList(ladderRewards);
    }

    public String getReward(Position position) {
        return ladderRewards.get(position.getPosition());
    }

    public List<String> getLadderRewards() {
        return ladderRewards;
    }
}
