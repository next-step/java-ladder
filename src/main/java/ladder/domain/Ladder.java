package ladder.domain;

import lombok.Getter;

import java.util.List;

public class Ladder {
    @Getter
    private List<Line> lines;
    @Getter
    private LadderReward ladderReward;

    public Ladder(int userCount, int height, LadderReward rewards) {
        this.lines = Line.listOf(userCount, height);
        this.ladderReward = rewards;
    }

    public String getReward(int startIndex) {
        int lineIndex = startIndex;

        for (Line line : this.lines) {
            lineIndex += line.getMovePoint(lineIndex);
        }

        return ladderReward.getReward(lineIndex);
    }
}
