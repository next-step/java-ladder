package nextstep.ladder.domain.direction;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Point {

    private static final Map<Integer, Map<Integer, Point>> cachedPoint;

    private final int x;
    private final int y;

    static {
        cachedPoint = new HashMap<>();
        IntStream.range(0, 10).forEach(x -> {
            Map<Integer, Point> points = new HashMap<>();
            IntStream.range(0, 10).forEach(y -> points.put(y, new Point(x, y)));
            cachedPoint.put(x, points);
        });
    }

    private Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Point from(int x, int y) {
        Map<Integer, Point> points = cachedPoint.get(x);
        if (points == null || !points.containsKey(y)) {
            return new Point(x, y);
        }
        return points.get(y);
    }

    public Point movePoint(Direction direction) {
        return from(direction.moveX(x), direction.moveY(y));
    }

    public int getX() {
        return x;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
