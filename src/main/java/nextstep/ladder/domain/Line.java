package nextstep.ladder.domain;

import nextstep.ladder.util.LineGenerator;

import java.util.List;

import static java.util.Collections.*;

public class Line {

    public static final int LEFTMOST = 0;
    public static final int PREVIOUS_COLUMN = -1;

    private final List<Point> points;

    public Line(int countOfPlayer) {
        this.points = LineGenerator.createLine(countOfPlayer);
    }

    public Line(List<Point> points) {
        this.points = points;
    }

    public boolean canGoRight(int currentColumn) {
        return points.get(currentColumn).isTrue();
    }

    public boolean canGoLeft(int currentColumn) {
        if (currentColumn == LEFTMOST) {
            return false;
        }
        return points.get(currentColumn + PREVIOUS_COLUMN).isTrue() && points.get(currentColumn).isFalse();
    }

    public List<Point> getPoints() {
        return unmodifiableList(points);
    }
}
