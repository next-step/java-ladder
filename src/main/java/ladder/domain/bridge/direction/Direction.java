package ladder.domain.bridge.direction;

public enum Direction {
    LEFT,
    DOWN,
    RIGHT;

    Direction() {
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
}
