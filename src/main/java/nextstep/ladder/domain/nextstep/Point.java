package nextstep.ladder.domain.nextstep;

public class Point {

    private final int index;

    private final Direction direction;

    public static Point first(Direction first) {
        return new Point(0, first);
    }

    public Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public int move() {
        return index + direction.move();
    }

    public Direction getDirection() {
        return direction;
    }
}
