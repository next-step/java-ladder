package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderCreator {
    private final int countOfPerson;
    private final int ladderHeight;

    public LadderCreator(final int countOfPerson, final int ladderHeight) {
        this.countOfPerson = countOfPerson;
        this.ladderHeight = ladderHeight;
    }

    public Ladder createLadder() {
        List<Line> lineList = new ArrayList<>();
        for (int idx = 0; idx < ladderHeight; idx++) {
            LineCreator lineCreator = new LineCreator(countOfPerson);
            Line line = lineCreator.createLine(false, 1);
            lineList.add(line);
        }
        return new Ladder(lineList);
    }
}
