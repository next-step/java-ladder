package ladder.domain;

public class Direction {

    private final boolean isLeft;
    private final boolean isRight;

    public Direction(boolean isLeft, boolean isRight) {
        this.isLeft = isLeft;
        this.isRight = isRight;
    }

    public boolean isLeft() {
        return isLeft;
    }

    public boolean isRight() {
        return isRight;
    }
}
