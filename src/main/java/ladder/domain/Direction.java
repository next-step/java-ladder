package ladder.domain;

public enum Direction {

    LEFT(-1),
    STRAIGHT(0),
    RIGHT(1);

    private final int value;

    private Direction(final int value) {
        this.value = value;
    }
}
