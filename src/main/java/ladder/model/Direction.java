package ladder.model;

import java.util.Arrays;

import static java.lang.Boolean.FALSE;
import static ladder.model.LadderPointGenerator.generatePoint;

public enum Direction {

    PASS(false, false),
    LEFT(true, false),
    RIGHT(false, true);

    private boolean left;
    private boolean right;

    Direction(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalStateException();
        }

        this.left = left;
        this.right = right;
    }

    public static Direction of(boolean left, boolean right) {
        return Arrays.stream(Direction.values())
                .filter(direction -> direction.left == left && direction.right == right)
                .findFirst().orElseThrow(IllegalStateException::new);
    }


    public boolean isRight() {
        return RIGHT.equals(this);
    }

    public boolean isLeft() {
        return LEFT.equals(this);
    }

    public Direction next(boolean nextRight) {
        return of(this.right, nextRight);
    }

    public Direction next() {
        if (this.right) {
            return next(FALSE);
        }
        return next(generatePoint());
    }

    public static Direction first(boolean right) {
        return of(FALSE, right);
    }

    public Direction last() {
        return of(this.right, FALSE);
    }

    @Override
    public String toString() {
        return "Direction{" +
                "left=" + left +
                ", right=" + right +
                '}';
    }
}