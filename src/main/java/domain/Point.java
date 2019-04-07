package domain;

public class Point {
    private static final Integer MIN_POINT_NUMBER = 1;

    private Integer location;
    private Boolean movable;

    private Point(Integer location, Boolean movable) {
        this.location = location;
        this.movable = movable;
    }

    public static Point valueOf(Integer idx, Boolean movable) {
        if(idx < MIN_POINT_NUMBER) {
            throw new IllegalArgumentException();
        }

        return new Point(idx, movable);
    }

    public static Point first(boolean movable) {
        return new Point(1, movable);
    }

    public static Point last(int location) {
        return new Point(location, false);
    }

    public static Point next(Point point, boolean movable) {
        if(point.isMovable()){
            return new Point(point.location + 1, false);
        }

        return new Point(point.location + 1, movable);
    }

    public Boolean isMovable() {
        return movable;
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
                && movable.equals(point.movable);
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
