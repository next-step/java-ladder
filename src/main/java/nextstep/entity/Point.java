package nextstep.entity;

public class Point {

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

    public static Point of(boolean leftPedal, boolean rightPedal) {
        return new Point(leftPedal, rightPedal);
    }
}
