package ladder.model;

public class Point {
    public static final String INVALID_POINT = "사다리의 연달은 라인이 겹칠 수는 없습니다.";

    private final boolean left;
    private final boolean current;

    private Point(boolean left, boolean current) {
        this.left = left;
        this.current = current;
    }

    public static Point of(boolean left, boolean current) {
        if (isImpossiblePoint(left, current)) {
            throw new IllegalArgumentException(INVALID_POINT);
        }

        return new Point(left, current);
    }

    private static boolean isImpossiblePoint(boolean left, boolean current) {
        return left == true && current == true;
    }

    protected int moveByDistance() {
        if (current) {
            return DirectionEnum.RIGHT.movement;
        }

        if (left) {
            return DirectionEnum.LEFT.movement;
        }

        return DirectionEnum.DOWN.movement;
    }

    protected boolean getPoint() {
        return current;
    }

    protected boolean getExPoint() {
        return left;
    }

}
