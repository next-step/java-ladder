package ladder.domain.ladder.point;

import ladder.exception.InvalidLegException;

public class Leg {

    private final boolean left;
    private final boolean right;

    private Leg(boolean left, boolean right) {
        validate(left, right);
        this.left = left;
        this.right = right;
    }

    public static Leg of(boolean left, boolean right) {
        return new Leg(left, right);
    }

    public static Leg first(boolean right) {
        return new Leg(false, right);
    }

    public static Leg first(PointGenerator pointGenerator) {
        return new Leg(false, pointGenerator.generate());
    }

    public Leg next(boolean right) {
        return new Leg(this.right, right);
    }

    public Leg next(PointGenerator pointGenerator) {
        if (right) {
            return new Leg(true, false);
        }
        return new Leg(false, pointGenerator.generate());
    }

    public Leg last() {
        return new Leg(right, false);
    }

    public Direction direction() {
        if (left) {
            return Direction.LEFT;
        }
        if (right) {
            return Direction.RIGHT;
        }
        return Direction.DOWN;
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }

    private void validate(boolean left, boolean right) {
        if (left && right) {
            throw new InvalidLegException();
        }
    }

    @Override
    public String toString() {
        return "Leg{" +
                "left=" + left +
                ", right=" + right +
                '}';
    }
}
