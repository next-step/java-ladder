package domain.ladder;

import java.util.HashMap;
import java.util.Map;

public class Point {
    private final int index;
    private final Direction direction;

    private static final Map<String, Point> cache = new HashMap<>();

    public Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public static Point of(int index, Direction direction){
        String key = String.valueOf(index + "_" + direction.isLeft() + "_" + direction.isRight());
        if(cache.containsKey(key)){
            Point point = cache.get(key);
            return point;
        }

        cache.put(key, new Point(index, direction));
        return cache.get(key);
    }

    public int move() {
        //System.out.println("is left? " + direction.isLeft());
        //System.out.println("is right? " + direction.isRight());

        if (direction.isRight()) {
            return index + 1;
        }

        if (direction.isLeft()) {
            return index - 1;
        }

        return this.index;
    }

    public Point next() {
        return Point.of(index + 1, direction.next());
    }

    public Point next(Boolean right) {
        return Point.of(index + 1, direction.next(right));
    }

    public Point last() {
        return Point.of(index + 1, direction.last());
    }

    public static Point first(Boolean right) {
        return Point.of(0, Direction.first(right));
    }

    public Direction getDirection() {
        return direction;
    }

    @Override
    public String toString() {
        return "Point{" +
                "index=" + index +
                ", direction=" + direction +
                '}';
    }
}