package nextstep.ladder.model;

public class Point {
    private int index;
    private Direction direction;

    public Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public int move() {
        if (direction.isLeft()) {
            return index - 1;
        }

        if (direction.isRight()) {
            return index + 1;
        }

        return index;
    }
}
