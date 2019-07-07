package ladder;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<LadderLine> ladderLines;
    private final LadderRewards ladderRewards;

    private Ladder(List<LadderLine> ladderLines, LadderRewards ladderRewards) {
        this.ladderLines = ladderLines;
        this.ladderRewards = ladderRewards;
    }

    public static Ladder of(int countOfPerson, String resultsString, int ladderHeight) {
        List<LadderLine> ladderLines = createLadderLines(countOfPerson, ladderHeight);
        LadderRewards ladderRewards = LadderRewards.of(resultsString);
        if (countOfPerson != ladderRewards.size()) {
            throw new IllegalStateException("the ladder must equals count of person and reward of ladder");
        }
        return new Ladder(ladderLines, ladderRewards);
    }

    public List<LadderLine> getLadderLines() {
        return Collections.unmodifiableList(ladderLines);
    }

    public LadderReward computePlayerReward(int playerPosition) {
        int rewardPosition = this.computeRewardPosition(playerPosition);
        return getReward(rewardPosition);
    }

    public LadderReward getReward(int rewardPosition) {
        return this.ladderRewards.getLadderReward(rewardPosition);
    }

    private static List<LadderLine> createLadderLines(int countOfPerson, int ladderHeight) {
        return IntStream.range(0, ladderHeight)
                        .mapToObj(index -> LadderLine.of(countOfPerson))
                        .collect(Collectors.toList());
    }

    private int computeRewardPosition(int beginPosition) {
        int nextPosition = beginPosition;

        for (LadderLine ladderLine : this.ladderLines) {
            nextPosition = ladderLine.computeNextPosition(nextPosition);
        }

        return nextPosition;
    }
}
