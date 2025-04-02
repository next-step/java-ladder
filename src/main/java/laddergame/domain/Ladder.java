package laddergame.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Line> points = new ArrayList<>();

    public Ladder(int lineNumber, int columnNumber) {
        for (int i = 0; i < lineNumber; ++i) {
            points.add(new Line(columnNumber));
        }
    }

    public List<Line> getPoints() {
        return points;
    }

}
