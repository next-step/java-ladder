package laddergame;

public class Point {
    private final int index;
    private final Direction direction;

    public Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public static Point first() {
        return new Point(0, Direction.first());
    }

    public Point last() {
        return new Point(this.index, this.direction.last());
    }


    public int move() {
        if (direction.isLeft()) {
            return index - 1;
        }

        if (direction.isRight()) {
            return index + 1;
        }

        return this.index;
    }

    public Point next() {
        return new Point(index + 1, direction.next());
    }

    public boolean isRight() {
        return direction.isRight();
    }
}
