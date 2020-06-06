package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderCreator {
    private final int countOfPerson;
    private final int ladderHeight;

    public LadderCreator(int countOfPerson,int ladderHeight) {
        this.countOfPerson = countOfPerson;
        this.ladderHeight = ladderHeight;
    }

    public Ladder createLadder() {
        List<Line> lineList = new ArrayList<>();
        for (int idx = 0; idx < ladderHeight; idx++) {
            Line line = new Line(countOfPerson);
            line.createLine(false, 1);
            lineList.add(line);
        }
        return new Ladder(lineList);
    }
}
