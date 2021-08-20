package ladder.domain;

public class Point {
    private final boolean isExistLeft;
    private final boolean isExistRight;

    private Point(boolean isExistLeft, boolean isExistRight) {
        this.isExistLeft = isExistLeft;
        this.isExistRight = isExistRight;
    }

    public static Point of(boolean isExistLeftBridge, boolean isExistRightBridge) {
        return new Point(isExistLeftBridge, isExistRightBridge);
    }

    public boolean existLeft() {
        return isExistLeft;
    }

    public boolean existRight() {
        return isExistRight;
    }
}
