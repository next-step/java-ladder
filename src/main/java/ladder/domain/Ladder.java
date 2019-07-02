package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private List<Line> lines;

    public Ladder(int countOfPerson, int ladderHeight) {
        this.lines = getLines(countOfPerson, ladderHeight);
    }

    private static List<Line> getLines(int countOfPerson, int ladderHeight) {
        List<Line> lines = new ArrayList<>();
        for (int index = 0; index < ladderHeight; index++) {
            lines.add(new Line(countOfPerson));
        }
        return lines;
    }

    public List<Line> getLines() {
        return lines;
    }
}
