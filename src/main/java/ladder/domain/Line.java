package ladder.domain;

import java.util.List;

public class Line {
    private final List<Direction> points;

    public Line(final List<Direction> points) {
        this.points = points;
    }

    public int move(int location) {
        Direction direction = points.get(location);
        if (direction.isLeft()) {
            return direction.goLeft(location);
        }
        if (direction.isRight()) {
            return direction.goRight(location);
        }
        return location;
    }

    public List<Direction> getPoints() {
        return points;
    }
}
