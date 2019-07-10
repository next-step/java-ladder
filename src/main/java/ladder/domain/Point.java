package ladder.domain;

public class Point {
    private final int index;
    private final boolean isLeft;
    private final boolean isRight;

    private Point(int index, boolean isLeft, boolean isRight) {
        this.index = index;
        this.isLeft = isLeft;
        this.isRight = isRight;
    }

    public static Point first(boolean isRight) {
        return new Point(0, false, isRight);
    }

    public int move() {
        if (isLeft) {
            return index - 1;
        }
        if (isRight) {
            return index + 1;
        }
        return index;
    }
}
