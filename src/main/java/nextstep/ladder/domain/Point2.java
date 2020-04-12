package nextstep.ladder.domain;

public class Point2 {
    private final int index;
    private final Direction direction;

    public Point2(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public int move() {
        System.out.println("is left? " + direction.isLeft());
        System.out.println("is right? " + direction.isRight());

        if (direction.isRight()) {
            return index + 1;
        }

        if (direction.isLeft()) {
            return index - 1;
        }

        return this.index;
    }

    public Point2 next() {
        return new Point2(index + 1, direction.next());
    }

    public Point2 next(Boolean right) {
        return new Point2(index + 1, direction.next(right));
    }

    public Point2 last() {
        return new Point2(index + 1, direction.last());
    }

    public static Point2 first(Boolean right) {
        return new Point2(0, Direction.first(right));
    }

    public boolean hasRightDirection() {
        return direction.isRight();
    }

    @Override
    public String toString() {
        return "Point{" +
                "index=" + index +
                ", direction=" + direction +
                '}';
    }
}
