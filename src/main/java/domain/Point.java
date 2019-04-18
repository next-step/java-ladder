package domain;

public class Point {
    private static final Integer FIRST_POINT_LOCATION = 1;
    private static final Integer POINT_INTERVAL = 1;

    private final Integer location;
    private Direction direction;

    private Point(Integer location, Direction direction) {
        this.location = location;
        this.direction = direction;
    }

    public static Point first(boolean movable) {
        return new Point(FIRST_POINT_LOCATION, Direction.first(movable));
    }

    public Point next(boolean movable) {
        return new Point(location + POINT_INTERVAL, direction.next(movable));
    }

    public Point last() {
        return new Point(location + POINT_INTERVAL, direction.last());
    }

    public Integer move() {
        if(direction.leftMovable()) {
            return location - POINT_INTERVAL;
        }

        if(direction.rightMovable()) {
            return location + POINT_INTERVAL;
        }

        return location;
    }

    public Integer getLocation() {
        return location;
    }

    public Direction getDirection() {
        return direction;
    }

    @Override
    public String toString() {
        return "|" + (direction.rightMovable() ? "-----" : "     ");
    }
}
