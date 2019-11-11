package ladder.domain.bridge;

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
