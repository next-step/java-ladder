package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Line> lines = new ArrayList<>();

    public Ladder(int countOfPerson, int height) {
        for (int i = 0; i < height; i++) {
            Line line = new Line(countOfPerson);
            this.lines.add(line);
        }
    }

    public Ladder(int countOfPerson, int height, List<List<Boolean>> points) {
        for (int i = 0; i < height; i++) {
            Line line = new Line(countOfPerson, points.get(i));
            this.lines.add(line);
        }
    }

    public void printLadder() {
        this.lines.forEach(Line::printLine);
    }
}
