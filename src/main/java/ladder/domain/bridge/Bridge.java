package ladder.domain.bridge;

import ladder.domain.bridge.direction.Direction;
import ladder.domain.common.Point;

public class Bridge {
    private final Point point;
    private final Direction direction;

    public Bridge(Point point, Direction direction) {
        this.point = point;
        this.direction = direction;
    }

    public int getY() {
        return point.getY();
    }

    public boolean isSamePoint(Point point) {
        return this.point.equals(point);
    }

    public Direction getDirection() {
        return direction;
    }
}
