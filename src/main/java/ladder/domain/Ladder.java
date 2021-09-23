package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private List<Line> lineList;
    private Lines lines;

    public Ladder(int heightOfLadder, int userCount) {
        lineList = new ArrayList<>();
        for (int i = 0; i < heightOfLadder; i++) {
            Line newLine = new Line(userCount);
            newLine.drawLine();
            lineList.add(newLine);
        }
        lines = new Lines(lineList);
    }

    public Lines lines() {
        return this.lines;
    }
}
