package nextstep.ladder.domain;

import static nextstep.ladder.domain.Direction.LEFT;
import static nextstep.ladder.domain.Direction.RIGHT;

public class Cross {
    private final int position;
    private final Point point;

    public Cross(final int position, final Point point) {
        this.position = position;
        this.point = point;
    }

    public Cross next(final Movable movable) {
        return new Cross(position + 1, point.next(movable));
    }

    public Cross next(final boolean right) {
        return new Cross(position + 1, point.next(right));
    }

    public static Cross first(final boolean right) {
        return new Cross(0, Point.first(right));
    }

    public boolean untilBeforeLastPoint(final int people) {
        return position < people - 2;
    }

    public Cross last() {
        return new Cross(position + 1, point.last());
    }

    public int move() {
        if (point.move() == RIGHT) {
            return position + 1;
        }

        if (point.move() == LEFT) {
            return position - 1;
        }
        return position;
    }

    public Point getPoint() {
        return point;
    }
}
