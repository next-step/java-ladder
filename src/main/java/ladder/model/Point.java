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

    public Point create(Point point, RandomStrategy randomStrategy) {
        if (point == null || !point.status) {
            return new Point(randomStrategy.hasPoint());
        }

        return new Point(false);
    }

    public boolean getStatus() {
        return this.status;
    }

    public static boolean previousStatus(List<Point> points, int position) {
        return points.get(position - 1).getStatus();
    }

    public static boolean currentStatus(List<Point> points, int position) {
        return points.get(position).getStatus();
    }

    @Override
    public String toString() {
        if (this.status) {
            return Ladder.LINE_WITH_POINTS.getShape();
        }

        return Ladder.LINE_ONLY.getShape();
    }
}
