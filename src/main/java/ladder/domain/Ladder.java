package ladder.domain;

import ladder.exception.ExceptionType;
import ladder.exception.LadderException;
import lombok.Getter;

import java.util.List;

public class Ladder {
    @Getter
    private List<Line> lines;
    @Getter
    private LadderReward ladderReward;

    public Ladder(List<Line> lines, LadderReward rewards) {
        validRewardSize(rewards, lines.get(0).getActionsSize());

        this.lines = lines;
        this.ladderReward = rewards;
    }

    public String getReward(int startIndex) {
        int lineIndex = startIndex;

        for (Line line : this.lines) {
            lineIndex += line.getMovePoint(lineIndex);
        }

        return ladderReward.getReward(lineIndex);
    }

    private void validRewardSize(LadderReward reward, int actionsSize) {
        if(!reward.sameSize(actionsSize)) {
            throw new LadderException(ExceptionType.INVALID_LINE_SIZE);
        }
    }
}
