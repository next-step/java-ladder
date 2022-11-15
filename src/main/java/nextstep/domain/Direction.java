package nextstep.domain;

public enum Direction {
    LEFT(-1),
    PASS(0),
    RIGHT(1);

    private final int direction;

    Direction(int direction) {
        this.direction = direction;
    }

    public int moveDirections() {
        return direction;
    }
}
