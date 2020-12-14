package ladder.domain;

public class Point {

    private final int index;
    private final PointStatus pointStatus;

    private Point(int index, PointStatus pointStatus) {
        this.index = index;
        this.pointStatus = pointStatus;
    }

    public static Point createFirstFrom(boolean atStatus) {
        return createCustomStatusOf(0, PointStatus.first(atStatus));
    }

    public Point createNextFrom(boolean atStatus) {
        return createCustomStatusOf(index + 1, pointStatus.next(atStatus));
    }

    public Point createLast() {
        return createCustomStatusOf(index + 1, pointStatus.last());
    }

    public static Point createCustomStatusOf(int index, PointStatus status) {
        return new Point(index, status);
    }

    public int nextIndex() {
        return pointStatus.nextIndex(index);
    }

    public PointStatus getPointStatus() {
        return pointStatus;
    }
}
