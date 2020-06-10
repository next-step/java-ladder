package ladder.domain;

import java.util.List;

public class Line {
    private final List<Boolean> points;

    public Line(final List<Boolean> points) {
        this.points = points;
    }

    public int move(int location) {
        int next = location;
        if (location != 0) {
            next = Direction.goLeft(points.get(location), location);
        }
        if (next != location) {
            return next;
        }
        if (location + 1 < points.size()) {
            next = Direction.goRight(points.get(location + 1), location);
        }
        return next;
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
