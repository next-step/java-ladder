package ladder.domain;

import ladder.exception.ExceptionType;
import ladder.exception.LadderException;
import lombok.Getter;

import java.util.List;

public class Ladder {
    @Getter
    private List<LadderLine> ladderLines;
    @Getter
    private LadderReward ladderReward;

    public Ladder(List<LadderLine> ladderLines, LadderReward rewards) {
        validRewardSize(rewards, ladderLines.get(0).getSize());

        this.ladderLines = ladderLines;
        this.ladderReward = rewards;
    }

    public String getReward(int startPosition) {
        int position = startPosition;

        for (LadderLine ladderLine : this.ladderLines) {
            position = ladderLine.move(position);
        }

        return ladderReward.getReward(position);
    }

    private void validRewardSize(LadderReward reward, int pointSize) {
        if (!reward.sameSize(pointSize)) {
            throw new LadderException(ExceptionType.INVALID_LINE_SIZE);
        }
    }
}
