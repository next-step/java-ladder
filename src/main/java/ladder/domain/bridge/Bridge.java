package ladder.domain.bridge;

import ladder.domain.common.Point;

public class Bridge {
    private final Point point;
    private final Direction direction;

    public Bridge(Point point, Direction direction) {
        this.point = point;
        this.direction = direction;
    }
}
