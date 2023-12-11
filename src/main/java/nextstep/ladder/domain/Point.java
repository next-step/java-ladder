package nextstep.ladder.domain;

public class Point {
    private final boolean leftConnected;
    private final boolean rightConnected;

    private Point(boolean leftConnected, boolean rightConnected) {
        if (leftConnected && rightConnected) {
            throw new IllegalArgumentException("양쪽으로 이어질수 없습니다.");
        }
        this.leftConnected = leftConnected;
        this.rightConnected = rightConnected;
    }

    public static Point first(boolean rightConnected) {
        return new Point(false, rightConnected);
    }

    public Point next(boolean newRightConnected) {
        return new Point(this.rightConnected, newRightConnected);
    }

    public Point last() {
        return new Point(this.rightConnected, false);
    }

    public boolean isLeftConnected() {
        return leftConnected;
    }

    public int moving() {
        return DirectionEnum.getDirection(leftConnected, rightConnected).getValue();
    }

}
