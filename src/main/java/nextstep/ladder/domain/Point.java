package nextstep.ladder.domain;

public class Point {

    private final int index;

    private final Direction direction;

    Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public int move() {
        return index + direction.move();
    }
}
