package ladder.domain;

import lombok.Getter;

import java.util.List;

public class Ladder {
    @Getter
    private List<Line> lines;
    @Getter
    private List<String> rewards;

    public Ladder(int userCount, int height, List<String> rewards) {
        this.lines = Line.listOf(userCount, height);
        this.rewards = rewards;
    }

    public String getReward(int startIndex) {
        int lineIndex = startIndex;

        for (Line line : this.lines) {
            lineIndex += line.getMovePoint(lineIndex);
        }

        return rewards.get(lineIndex);
    }
}
