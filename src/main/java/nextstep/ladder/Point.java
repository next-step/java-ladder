package nextstep.ladder;

import java.util.Objects;
import nextstep.ladder.drawPolicy.DrawablePolicy;

public class Point {

    private final boolean leftConnected;
    private final boolean rightConnected;

    public static Point createInstance(Point currentPoint, DrawablePolicy randomDraw) {
        return currentPoint.next(randomDraw);
    }

    public static Point createInstance(DrawablePolicy randomDraw) {
        return firstPoint(randomDraw);
    }

    public static Point lastInstance(Point currentPoint) {
        return lastPoint(currentPoint);
    }

    private static Point firstPoint(DrawablePolicy drawable) {
        return new Point(false, drawable.draw());
    }

    private static Point lastPoint(Point currentPoint) {
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

    private Point(boolean leftConnected, boolean rightConnected) {
        this.leftConnected = leftConnected;
        this.rightConnected = rightConnected;
    }

    public boolean isLeftConnected() {
        return leftConnected;
    }

    public boolean isRightConnected() {
        return rightConnected;
    }
}
