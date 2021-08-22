package nextstep.ladder.domain;

public enum Direction {

    LEFT(-1),
    STRAIGHT(0),
    RIGHT(1);

    private final int value;

    Direction(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }
}
