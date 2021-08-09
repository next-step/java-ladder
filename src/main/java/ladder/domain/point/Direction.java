package ladder.domain.point;

public enum Direction {
    LEFT, RIGHT, EMPTY;

    public boolean isLeft() {
        return this == LEFT;
    }

    public boolean isRight() {
        return this == RIGHT;
    }

    public boolean isEmpty() {
        return this == EMPTY;
    }
}
