package ladder.model;

import java.util.Objects;

public class Step {

    private final int position;
    private final Direction direction;

    public Step(int position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    public static Step first(boolean right) {
        return new Step(0, new Direction(false, right));
    }

    public Step last() {
        return next(false);
    }

    public Step next(boolean generateRight) {
        return new Step(position + 1, direction.next(generateRight));
    }

    public int move() {
        return position + direction.move();
    }

    public boolean hasRight() {
        return direction.isRight();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Step step = (Step) o;
        return position == step.position &&
                Objects.equals(direction, step.direction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, direction);
    }

}
