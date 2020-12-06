package nextstep.ladder.domain;

public class Point {

    private int index;
    private Direction direction;

    private Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public static Point from(int index, Direction direction) {
        return new Point(index, direction);
    }

    public Direction getDirection() {
        return direction;
    }
}
