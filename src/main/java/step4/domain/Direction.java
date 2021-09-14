package step4.domain;

public enum Direction {
    LEFT, RIGHT, DOWN;

    public boolean isRight() {
        return this == RIGHT;
    }

    public boolean isLeft() {
        return this == LEFT;
    }
}
