package ladder.model;

import java.util.List;

public class Ladder {
    private final List<Line> ladder;

    public Ladder(List<Line> ladder) {
        this.ladder = ladder;
    }

    public int getHeightOfLadder() {
        return ladder.size();
    }

    public Line getNthOfLadder(int index) {
        return ladder.get(index);
    }
}
