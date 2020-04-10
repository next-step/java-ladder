package ladder.model;

import java.util.Random;

public class Point {

    private static final Random RANDOM = new Random();

    private final LadderPole polePosition;
    private final DirectionTdd direction;

    public Point(final LadderPole polePosition, final DirectionTdd direction) {
        this.polePosition = polePosition;
        this.direction = direction;
    }

    public static Point first(final Boolean right) {
        return new Point(LadderPole.of(0), DirectionTdd.first(right));
    }

    public static Boolean generatePoint() {
        return RANDOM.nextBoolean();
    }

    public static Point of(final Point point) {
        return new Point(point.polePosition, point.direction);
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

    public Point next() {
        return new Point(polePosition.plus(), direction.next());
    }

    public Point next(final Boolean right) {
        return new Point(polePosition.plus(), direction.next(right));
    }

    public Point last() {
        return new Point(polePosition.plus(), direction.last());
    }

    @Override
    public String toString() {
        return "Point{" +
                "index=" + polePosition.toInt() +
                ", direction=" + direction +
                '}';
    }
}
