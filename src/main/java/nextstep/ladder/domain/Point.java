package nextstep.ladder.domain;

public class Point {

    private int index;
    private Direction direction;

    public Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }
}
