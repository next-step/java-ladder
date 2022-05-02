package nextstep.ladder.domain;

import nextstep.ladder.util.LineGenerator;

import java.util.List;

import static java.util.Collections.*;

public class Line {

    public static final int LEFTMOST = 0;
    public static final int PREVIOUS_COLUMN = -1;

    private final List<Boolean> points;

    public Line(int countOfPlayer) {
        this.points = LineGenerator.createLine(countOfPlayer);
    }

    public Line(List<Boolean> points) {
        this.points = points;
    }

    public boolean canGoRight(int currentColumn) {
        return points.get(currentColumn);
    }

    public boolean canGoLeft(int currentColumn) {
        if (currentColumn == LEFTMOST) {
            return false;
        }
        return points.get(currentColumn + PREVIOUS_COLUMN) && !points.get(currentColumn);
    }

    public List<Boolean> getPoints() {
        return unmodifiableList(points);
    }
}
