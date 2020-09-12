package nextstep.entity;

public class Point {

    private static final boolean NO_PEDAL = false;
    private final boolean leftPedal;
    private final boolean rightPedal;

    private Point(boolean leftPedal, boolean rightPedal) {
        this.leftPedal = leftPedal;
        this.rightPedal = rightPedal;
    }

    public boolean hasLeftPedal() {
        return this.leftPedal;
    }

    public boolean hasRightPedal() {
        return this.rightPedal;
    }

    public int play(int index) {
        if (leftPedal) {
            return index - 1;
        }
        if (rightPedal) {
            return index + 1;
        }
        return index;
    }

    public static Point of(boolean leftPedal, boolean rightPedal) throws IllegalArgumentException {
        if (leftPedal && rightPedal) {
            throw new IllegalArgumentException("좌측과 우측 모두 페달을 생성할 수 없습니다.");
        }
        return new Point(leftPedal, rightPedal);
    }

    public Point next(boolean nextRightPedal) {
        if (this.rightPedal) {
            return Point.of(true, NO_PEDAL);
        }
        return Point.of(NO_PEDAL, nextRightPedal);
    }

    public static Point getStartPoint(boolean nextRightPedal) {
        return Point.of(NO_PEDAL, nextRightPedal);
    }

    public Point getLastPoint() {
        return Point.of(this.rightPedal, NO_PEDAL);
    }

    public static Point getSinglePoint() {
        return Point.of(NO_PEDAL, NO_PEDAL);
    }
}
