package nextstep.ladder.domain;

public class Point {

    private int point;
    private Direction direction;

    public Point(int point, Direction direction) {
        this.point = point;
        this.direction = direction;
    }

    public int move() {
        return direction.nextPoint(point);
    }

    public Direction direction() {
        return this.direction;
    }
}
