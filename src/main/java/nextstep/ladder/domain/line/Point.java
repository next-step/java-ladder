package nextstep.ladder.domain.line;

public class Point {

    private final boolean point;

    public Point(boolean point) {
        this.point = point;
    }

    public boolean isPointFalse() {
        return !point;
    }

    public boolean isPointTrue() {
        return point;
    }

    public Point decideNextPoint(Boolean randomBoolean) {
        if (!point) {
            return new Point(randomBoolean);
        }
        return new Point(false);
    }
}
