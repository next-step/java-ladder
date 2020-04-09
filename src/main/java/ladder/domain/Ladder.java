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
        validRewardSize(rewards, ladderLines.get(0).getActionsSize());

        this.ladderLines = ladderLines;
        this.ladderReward = rewards;
    }

    public String getReward(int startIndex) {
        int lineIndex = startIndex;

        for (LadderLine ladderLine : this.ladderLines) {
            lineIndex += ladderLine.getMovePoint(lineIndex);
        }

        return ladderReward.getReward(lineIndex);
    }

    private void validRewardSize(LadderReward reward, int actionsSize) {
        if(!reward.sameSize(actionsSize)) {
            throw new LadderException(ExceptionType.INVALID_LINE_SIZE);
        }
    }
}
