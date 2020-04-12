package ladder.model;

public class Point {

    private final LadderPole polePosition;
    private final Direction direction;

    public Point(final LadderPole polePosition, final Direction direction) {
        this.polePosition = polePosition;
        this.direction = direction;
    }

    public static Point first(final Boolean right) {
        return new Point(LadderPole.of(0), Direction.first(right));
    }


    public static Point of(final Point point) {
        return new Point(point.polePosition, point.direction);
    }

    public Point next() {
        return new Point(polePosition.plus(), direction.next());
    }

    public Point next(final Boolean right) {
        return new Point(polePosition.plus(), direction.next(right));
    }

    public Point last() {
        return new Point(polePosition.plus(), direction.last());
    }

    public LadderPole move() {

        if (direction.isRight()) {
            return polePosition.plus();
        }

        if (direction.isLeft()) {
            return polePosition.minus();
        }

        return polePosition;
    }

    @Override
    public String toString() {
        return "Point{" +
                "index=" + polePosition.toInt() +
                ", direction=" + direction +
                '}';
    }

}
