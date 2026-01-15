package nextstep.ladder.domain;

public enum Direction {
    LEFT(-1),
    RIGHT(1),
    DOWN(0);

    private final int value;

    Direction(int value) {
        this.value = value;
    }

    public int move() {
        return value;
    }

    public boolean isRight() {
        return this == RIGHT;
    }
}