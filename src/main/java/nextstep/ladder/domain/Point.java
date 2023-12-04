package nextstep.ladder.domain;

public class Point {
    public final static Point TRUE = new Point(true);
    public final static Point FALSE = new Point(false);

    private final boolean point;

    public Point(boolean point) {
        this.point = point;
    }

    public boolean isPoint() {
        return this.point;
    }

    @Override
    public String toString() {
        return "Point{" +
                "point=" + point +
                '}';
    }
}
