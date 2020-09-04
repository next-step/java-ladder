package ladder.domain;

public class Point {

    private final BarType barType;
    private Direction direction;

    private Point() {
        this.barType = BarType.NONE;
    }

    private Point(BarType barType) {
        this.barType = barType;
    }

    private static Point of(Point point, BarCreator barCreator) {
        if (point.barType == BarType.LEFT) {
            return new Point(BarType.NONE);
        }
        return new Point(BarType.of(barCreator.create()));
    }

    public BarType getBarType() {
        return barType;
    }
}
