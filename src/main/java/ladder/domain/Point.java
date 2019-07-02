package ladder.domain;

public class Point {

    private static final int FIRST = 0;
    private int position;
    private Direction direction;

    public Point(int position, Direction direction) {

        this.position = position;
        this.direction = direction;
    }

    public static Point first(boolean generateValue) {

        return new Point(FIRST, Direction.first(generateValue));
    }

    public static Point middle(int position, Direction before, boolean generateValue) {

        return new Point(position, Direction.middle(before, generateValue));
    }

    public static Point last(int lastPosition, Direction before) {

        return new Point(lastPosition, Direction.last(before));
    }

    public Direction getDirection() {

        return direction;
    }
}
