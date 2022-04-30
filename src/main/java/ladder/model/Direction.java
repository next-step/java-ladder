package ladder.model;

public class Direction {

    private final boolean isLeft;

    private final boolean isRight;

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

    public int move(int index) {
        if(isLeft) {
            return index - 1;
        }

        if(isRight) {
            return index + 1;
        }

        return index;
    }
}
