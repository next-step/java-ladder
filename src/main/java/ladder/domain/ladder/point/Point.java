package ladder.domain.ladder.point;

public class Point {

    private final int index;
    private final Leg leg;

    private Point(int index, Leg leg) {
        validate(index);
        this.index = index;
        this.leg = leg;
    }

    public static Point of(int index, Leg leg) {
        return new Point(index, leg);
    }

    public static Point first(boolean right) {
        return new Point(0, Leg.first(right));
    }

    public static Point first(PointGenerator pointGenerator) {
        return new Point(0, Leg.first(pointGenerator));
    }

    public Point next(boolean right) {
        return new Point(index + 1, leg.next(right));
    }

    public Point next(PointGenerator pointGenerator) {
        return new Point(index + 1, leg.next(pointGenerator));
    }

    public Point last() {
        return new Point(index + 1, leg.last());
    }

    public int permute() {
        if (leg.direction() == Direction.LEFT) {
            return index - 1;
        }
        if (leg.direction() == Direction.RIGHT) {
            return index + 1;
        }
        return index;
    }

    public Leg getLeg() {
        return leg;
    }

    private void validate(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public String toString() {
        return "Point{" +
                "index=" + index +
                ", leg=" + leg +
                '}';
    }
}
