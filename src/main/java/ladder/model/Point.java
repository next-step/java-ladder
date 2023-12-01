package ladder.model;

import java.util.List;

public class Point {

    private final boolean status;

    public Point(boolean status) {
        this.status = status;
    }

    public Point() {
        this(false);
    }

    public static Point create(Point point, RandomStrategy randomStrategy) {
        if (point == null || !point.status) {
            return new Point(randomStrategy.hasPoint());
        }

        return new Point(false);
    }

    public boolean getStatus() {
        return this.status;
    }

    public static boolean isStay(List<Point> points, int position) {
        return position == points.size() && !hasPoint(points, position - 1);
    }

    public static boolean isLeftLadderHasPoint(List<Point> points, int position) {
        return position > 0 && hasPoint(points, position - 1);
    }

    public static boolean isRightLadderHasPoint(List<Point> points, int position) {
        return position < points.size() && hasPoint(points, position);
    }

    public static boolean hasPoint(List<Point> points, int location) {
        return points.get(location).getStatus();
    }


    @Override
    public String toString() {
        if (this.status) {
            return Ladder.LINE_WITH_POINTS.getShape();
        }

        return Ladder.LINE_ONLY.getShape();
    }
}
