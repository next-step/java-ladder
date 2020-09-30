package nextstep.ladder.domain;

public enum Direction {
    LEFT(-1),
    RIGHT(1),
    STOP(0);

    private final int direction;

    private Direction(int direction) {
        this.direction = direction;
    }

    public Lane changeLane(int index) {
        return Lane.of(index + direction);
    }
}
