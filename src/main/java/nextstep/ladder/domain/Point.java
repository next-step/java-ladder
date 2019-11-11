package nextstep.ladder.domain;

public class Point {
    private Direction direction;

    public Point(Direction direction) {
        this.direction = direction;
    }

    public Direction direction() {
        return direction;
    }
}
