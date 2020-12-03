package ladder.domain;

import java.util.*;

public class Point {

    private static final List<Point> pointSet = new LinkedList<>();
    private static final int FIRST_INDEX = 0;
    private final boolean movable;

    static {
        pointSet.add(new Point(true));
        pointSet.add(new Point(false));
    }

    private Point(boolean movable) {
        this.movable = movable;
    }

    public static Point of(boolean point) {
        return pointSet.stream()
                .filter(e -> e.movable == point)
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    public static Point shuffle() {
        Collections.shuffle(pointSet);
        return pointSet.get(FIRST_INDEX);
    }

    public boolean isMovable() {
        return movable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return movable == point.movable;
    }

    @Override
    public int hashCode() {
        return Objects.hash(movable);
    }
}
