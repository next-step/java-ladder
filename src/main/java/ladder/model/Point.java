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

    public static Point first(Boolean right) {
        return new Point(LadderPole.of(0), DirectionTdd.first(right));
    }

    public static Boolean generatePoint() {
        return RANDOM.nextBoolean();
    }

    public int move() {

        if (direction.isRight()) {
            return polePosition.toInt() + 1;
        }

        if (direction.isLeft()) {
            return polePosition.toInt() - 1;
        }

        return polePosition.toInt();
    }

    public Point next() {
        return new Point(polePosition.plus(), direction.next());
    }

    public Point next(Boolean right) {
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
