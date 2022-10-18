package ladder.model;

import java.util.List;

public class Ladder {
    private List<Point> ladderLine;

    public Ladder(LadderFactory ladderFactory) {
        this.ladderLine = ladderFactory.create();
    }
}
