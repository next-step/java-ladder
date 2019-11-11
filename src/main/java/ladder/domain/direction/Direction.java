package ladder.domain.direction;

public enum Direction {
    LEFT,
    DOWN,
    RIGHT;

    Direction() {
    }


    public static Direction getDirection(WayGenerator wayGenerator) {
        return wayGenerator.getWay() ? RIGHT : DOWN;
    }
}
