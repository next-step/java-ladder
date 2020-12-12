package ladder.domain;

public class Point {

    private final int index;
    private final PointStatus pointStatus;

    private Point(int index, PointStatus pointStatus) {
        this.index = index;
        this.pointStatus = pointStatus;
    }

    public static Point first(boolean atStatus) {
        return custom(0, PointStatus.first(atStatus));
    }

    public static Point custom(int index, PointStatus status) {
        return new Point(index, status);
    }

    public Point next(boolean atStatus) {
        return custom(index + 1, pointStatus.next(atStatus));
    }

    public Point last() {
        return custom(index + 1, pointStatus.last());
    }

    public int nextIndex() {
        return pointStatus.nextIndex(index);
    }

    public PointStatus getPointStatus() {
        return pointStatus;
    }
}
