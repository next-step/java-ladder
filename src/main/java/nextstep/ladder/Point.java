package nextstep.ladder;

import java.util.Objects;

import nextstep.ladder.drawPolicy.DrawablePolicy;

public class Point {

    public static final int DISTANCE = 1;
    private final boolean leftConnected;
    private final boolean rightConnected;


    public static Point createInstance(Point currentPoint, DrawablePolicy randomDraw) {
        return currentPoint.next(randomDraw);
    }

    public static Point createInstance(DrawablePolicy randomDraw) {
        return new Point(false, randomDraw.draw());
    }

    public static Point lastInstance(Point currentPoint) {
        return new Point(currentPoint.isRightConnected(), false);
    }

    protected Point next(DrawablePolicy drawable) {
        if (isLeftConnected()) {
            return new Point(false, drawable.draw());
        }
        if (isRightConnected()) {
            return new Point(true, false);
        }
        return new Point(false, drawable.draw());
    }

    protected Point(boolean leftConnected, boolean rightConnected) {
        this.leftConnected = leftConnected;
        this.rightConnected = rightConnected;
    }

    public boolean isLeftConnected() {
        return leftConnected;
    }

    public boolean isRightConnected() {
        return rightConnected;
    }

    public int calculateMovedIndex(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("사다리 포인트는 음수가 될 수 없습니다.");
        }
        if (isRightConnected()) {
            return index + DISTANCE;
        }
        if (isLeftConnected()) {
            return index - DISTANCE;
        }
        return index;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Point point = (Point) o;
        return leftConnected == point.leftConnected && rightConnected == point.rightConnected;
    }

    @Override
    public int hashCode() {
        return Objects.hash(leftConnected, rightConnected);
    }
}
