package ladder.model;

import java.util.Random;

public class PointTdd {
    private static final Random RANDOM = new Random();

    private final int index;
    private final DirectionTdd direction;

    public PointTdd(int index, DirectionTdd direction) {
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

    public PointTdd next() {
        return new PointTdd(index + 1, direction.next());
    }

    public PointTdd next(Boolean right) {
        return new PointTdd(index + 1, direction.next(right));
    }

    public PointTdd last() {
        return new PointTdd(index + 1, direction.last());
    }

    public static PointTdd first(Boolean right) {
        return new PointTdd(0, DirectionTdd.first(right));
    }

    public static Boolean generatePoint() {
        return RANDOM.nextBoolean();
    }

    @Override
    public String toString() {
        return "Point{" +
                "index=" + index +
                ", direction=" + direction +
                '}';
    }
}
