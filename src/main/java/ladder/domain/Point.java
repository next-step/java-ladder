package ladder.domain;

public class Point {

    private final BarType barType;
    private Direction direction;

    private Point() {
        this.barType = BarType.NONE;
        this.direction = Direction.NONE;
    }

    private Point(BarType barType) {

        this.barType = barType;

        if (barType == BarType.LEFT) {
            this.direction = Direction.LEFT;
            return;
        }

        this.direction = Direction.NONE;
    }

    public static Point first() {
        return new Point();
    }

    public static Point of(Point leftPoint, BarCreator barCreator) {
        if (leftPoint.getBarType() == BarType.LEFT) {
            return new Point(BarType.NONE);
        }
        return new Point(BarType.of(barCreator.create()));
    }

    public BarType getBarType() {
        return barType;
    }

    public boolean hasBar() {
        return this.barType == BarType.LEFT;
    }

    @Override
    public String toString() {
        return barType.toString();
    }

    public int move() {
        return direction.move();
    }

    public void setDirection(Point rightPoint) {
        if (this.barType == BarType.NONE && rightPoint.hasBar()) {
            this.direction = Direction.RIGHT;
        }
    }
}
