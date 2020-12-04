package nextstep.ladder.domain;

public class Point {

    private int index;
    private Direction direction;

    public Point() {}

    public Point(int index) {
        this.index = index;
    }

    public Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public Point from(int index) {
        return new Point(index, direction);
    }

}
