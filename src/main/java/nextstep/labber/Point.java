package nextstep.labber;

public class Point {

    private final boolean prev;
    private final boolean current;

    private Point(boolean prev, boolean current) {
        if (prev && current) {
            throw new IllegalArgumentException("Two lines cannot be continuous.");
        }
        this.prev = prev;
        this.current = current;
    }

    public static Point first() {
        return new Point(false, Utils.randomPoint());
    }

    public static Point first(boolean point) {
        return new Point(false, point);
    }

    public Compass move() {
        if (!this.prev && this.current) {
            return Compass.RIGHT;
        }

        if (this.prev && !this.current) {
            return Compass.LEFT;
        }
        return Compass.DOWN;
    }

    public Point next() {
        return new Point(this.current, this.defaultPoint());
    }

    public boolean defaultPoint() {
        if (this.current) {
            return false;
        }
        return Utils.randomPoint();
    }

    public Point next(boolean point) {
        return new Point(this.current, point);
    }

    public Point last() {
        return new Point(this.current, false);
    }

    @Override
    public String toString() {
        return "Point{" +
                "prev=" + prev +
                ", current=" + current +
                '}';
    }
}
