package domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Point implements Comparable<Point>{
    private final Integer x;
    private final Integer y;

    private Point(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public static Point valueOf(Integer x, Integer y) {
        if(x <= 0 || y <= 0) {
            throw new IllegalArgumentException();
        }

        return new Point(x, y);
    }

    public static List<Point> valuesOf(Integer width, Integer height) {
        return IntStream.rangeClosed(1, height)
            .boxed()
            .flatMap(y -> IntStream.rangeClosed(1, width).mapToObj(x -> Point.valueOf(x, y)))
            .collect(Collectors.toList());
    }

    public Integer distanceOfX(Point point) {
        return Math.abs(x - point.getX());
    }

    public Integer distanceOfY(Point point) {
        return Math.abs(y - point.getY());
    }

    public Point increaseX() {
        return Point.valueOf(x + 1, y);
    }

    public Point increaseY() {
        return Point.valueOf(x, y + 1);
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

    @Override
    public int compareTo(Point point) {
        if(y.equals(point.y)) {
            return x.compareTo(point.x);
        }

        return y.compareTo(point.y);
    }
}
