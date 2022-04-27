package ladder.model;

public class Point {

    private int index;

    private final Direction direction;

    private Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public static Point of(int index, Direction direction) {
        return new Point(index, direction);
    }

}
