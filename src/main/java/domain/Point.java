package domain;

public class Point {
    private Integer x;
    private Integer y;

    private Point(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public static Point of(Integer x, Integer y) {
        if(x <= 0 || y <= 0) {
            throw new IllegalArgumentException();
        }

        return new Point(x, y);
    }

    public Integer distanceOfX(Point point) {
        return Math.abs(x - point.getX());
    }

    public Integer distanceOfY(Point point) {
        return Math.abs(y - point.getY());
    }

    public Point increaseX() {
        return Point.of(x + 1, y);
    }

    public Point increaseY() {
        return Point.of(x, y + 1);
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
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
            return x.equals(point.x) && y.equals(point.y);
        }

        return false;
    }

    @Override
    public int hashCode() {
        return x.hashCode() + y.hashCode();
    }
}
