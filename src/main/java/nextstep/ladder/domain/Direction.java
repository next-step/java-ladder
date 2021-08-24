package nextstep.ladder.domain;

public enum Direction {

    LEFT(-1),
    STRAIGHT(0),
    RIGHT(1);

    private final int value;

    Direction(int value) {
        this.value = value;
    }

    public boolean isRight() {
        return this == RIGHT;
    }

    public boolean isLeft() {
        return this == LEFT;
    }

    public boolean isStraight() {
        return this == STRAIGHT;
    }
}
