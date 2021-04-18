package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Line> lines;

    public Ladder() {
        this(new ArrayList<>());
    }

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public void add(Line line) {
        lines.add(line);
    }

    public int arrivalPoint(int startPoint) {
        int currentPoint = startPoint;
        for (Line line : lines) {
            currentPoint = line.move(currentPoint);
        }
        return currentPoint;
    }

    public List<Line> getLines() {
        return lines;
    }
}
