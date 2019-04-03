package domain;

public class Point {
    private static final Integer MIN_POINT_NUMBER = 1;

    private Integer idx;
    private Boolean movable;

    private Point(Integer idx, Boolean movable) {
        this.idx = idx;
        this.movable = movable;
    }

    public static Point valueOf(Integer idx, Boolean movable) {
        validatePoint(idx);

        return new Point(idx, movable);
    }

    private static void validatePoint(Integer idx) {
        if(idx < MIN_POINT_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    public Point next(Boolean movable) {
        if(this.movable) {
            return Point.valueOf(idx + 1, false);
        }

        return Point.valueOf(idx + 1, movable);
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
            return idx.equals(point.idx);
        }

        return false;
    }

    @Override
    public int hashCode() {
        return idx.hashCode();
    }

    @Override
    public String toString() {
        return "|";
    }
}
