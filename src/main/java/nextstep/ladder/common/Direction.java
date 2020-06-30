package nextstep.ladder.common;

public enum Direction {
    LEFT(-1),
    CENTER(0),
    RIGHT(1);

    private final int value;

    Direction(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
