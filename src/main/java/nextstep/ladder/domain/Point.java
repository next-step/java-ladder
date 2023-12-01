package nextstep.ladder.domain;

import static nextstep.ladder.domain.Direction.CENTER;
import static nextstep.ladder.domain.Direction.LEFT;

public class Point {

    public static final String TRUE_BRIDGE = "-----";
    public static final String FALSE_BRIDGE = "     ";

    private final int point;
    private final Direction direction;

    public Point(int point, Direction direction) {
        this.point = point;
        this.direction = direction;
    }

    public int move() {
        return direction.nextPoint(point);
    }

    @Override
    public String toString() {
        if (LEFT.equals(direction) || CENTER.equals(direction)) {
            return FALSE_BRIDGE;
        }

        return TRUE_BRIDGE;
    }
}
