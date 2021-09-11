package step2.domain;

public class Point {
    private final boolean point;

    public Point(PointStrategy pointStrategy) {
        this(pointStrategy.create());
    }

    public Point() {
        this(false);
    }

    public Point(boolean point) {
        this.point = point;
    }

    public boolean isTrue() {
        return point == true;
    }

    @Override
    public String toString() {
        if (point) {
            return "-----|";
        }
        return "     |";
    }
}
