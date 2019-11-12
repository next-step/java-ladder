package ladder.domain.bridge.direction;

import ladder.domain.common.MoveStrategy;
import ladder.domain.common.Point;

public enum Direction {
    LEFT(Point::moveLeft),
    DOWN(Point::moveDown),
    RIGHT(Point::moveRight);

    private final MoveStrategy moveStrategy;

    Direction(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public static Direction getDirection(WayGenerator wayGenerator) {
        return wayGenerator.getWay() ? RIGHT : DOWN;
    }

    public static Direction getMiddleDirection(WayGenerator wayGenerator, Direction beforeDirection) {
        if (beforeDirection.equals(RIGHT)) {
            return LEFT;
        }
        return getDirection(wayGenerator);
    }

    public static Direction getLastDirection(Direction beforeDirection) {
        if (beforeDirection.equals(RIGHT)) {
            return LEFT;
        }
        return DOWN;
    }

    public Point move(Point point) {
        return moveStrategy.move(point);
    }
}
