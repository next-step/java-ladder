package ladder.domain;

public class Point {
    private final boolean hasPoint;

    public Point(boolean hasPoint) {
        this.hasPoint = hasPoint;
    }

    public boolean hasPoint() {
        return this.hasPoint;
    }

    public boolean canDrawNext() {
        return !hasPoint;
    }

}
