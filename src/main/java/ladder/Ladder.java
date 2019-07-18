package ladder;

import ladder.domain.LadderLines;
import ladder.domain.LadderRewards;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final LadderLines ladderLines;
    private final LadderRewards ladderRewards;

    private Ladder(LadderLines ladderLines, LadderRewards ladderRewards) {
        this.ladderLines = ladderLines;
        this.ladderRewards = ladderRewards;
    }

    public static Ladder of(int countOfPerson, String resultsString, int ladderHeight) {
        LadderLines ladderLines = LadderLines.of(countOfPerson, ladderHeight);
        LadderRewards ladderRewards = LadderRewards.of(resultsString);
        if (countOfPerson != ladderRewards.size()) {
            throw new IllegalStateException("the ladder must equals count of person and reward of ladder");
        }
        return new Ladder(ladderLines, ladderRewards);
    }

    public LadderLines getLadderLines() {
        return this.ladderLines;
    }

    public LadderReward computePlayerReward(int playerPosition) {
        int rewardPosition = this.ladderLines.computeRewardPosition(playerPosition);
        return getReward(rewardPosition);
    }

    public LadderReward getReward(int rewardPosition) {
        return this.ladderRewards.getLadderReward(rewardPosition);
    }
}
