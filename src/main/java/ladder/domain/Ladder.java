package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private List<Line> lineList;
    private Lines lines;

    public Ladder(int heightOfLadder, int userCount) {
        lineList = new ArrayList<>();
        for (int i = 0; i < heightOfLadder; i++) {
            lineList.add(new Line(userCount));
        }
        lines = new Lines(lineList);
    }

    public Lines lines() {
        return this.lines;
    }
}
