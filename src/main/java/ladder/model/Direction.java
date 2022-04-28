package ladder.model;

public class Direction {

    private boolean isLeft;

    private boolean isRight;

    private Direction(boolean isLeft, boolean isRight) {
        this.isLeft = isLeft;
        this.isRight = isRight;
    }

    public static Direction of(boolean isLeft, boolean isRight) {
        return new Direction(isLeft, isRight);
    }

    public boolean isLeft() {
        return isLeft;
    }

    public boolean isRight() {
        return isRight;
    }

}
