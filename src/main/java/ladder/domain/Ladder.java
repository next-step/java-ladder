package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<Line> lines = new ArrayList<>();

    public Ladder(int countOfPerson, int ladderHeight) {
        RandomPointCondition pointCondition = new RandomPointCondition();
        for (int i = 0; i < ladderHeight; i++) {
            lines.add(new Line(countOfPerson, pointCondition));
        }
    }

    public List<Line> getLines() {
        return lines;
    }

    public Line getLine(int index) {
        return lines.get(index);
    }
}
