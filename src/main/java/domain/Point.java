package domain;

public class Point {
    private static final Integer MIN_CREATABLE_POINT_NUMBER = 2;

    private Integer location;
    private Direction direction;

    private Point(Integer location, Direction direction) {
        this.location = location;
        this.direction = direction;
    }

    public static Point valueOf(Integer idx, boolean movable) {
        if(idx < MIN_CREATABLE_POINT_NUMBER) {
            throw new IllegalArgumentException();
        }

        return new Point(idx, Direction.nextDirection(movable));
    }

    public static Point first(boolean movable) {
        return new Point(1, Direction.nextDirection(movable));
    }

    public static Point last(Point point) {
        if(point.direction == Direction.RIGHT) {
            return new Point(point.location + 1, Direction.LEFT);
        }

        return new Point(point.location + 1, Direction.NONE);
    }

    public static Point next(Point point, boolean movable) {
        if(point.direction == Direction.RIGHT){
            return new Point(point.location + 1, Direction.LEFT);
        }

        return new Point(point.location + 1, Direction.nextDirection(movable));
    }

    public boolean rightMovable() {
        return direction == Direction.RIGHT;
    }

    public boolean leftMovable() {
        return direction == Direction.LEFT;
    }


    public Integer getLocation() {
        return location;
    }

    public Direction getDirection() {
        return direction;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        }

        if(obj == this) {
            return true;
        }

        if(obj.getClass() == getClass()) {
            Point point = (Point) obj;
            return location.equals(point.location)
                && direction == point.direction;
        }

        return false;
    }

    @Override
    public int hashCode() {
        return location.hashCode();
    }

    @Override
    public String toString() {
        return "|";
    }
}
