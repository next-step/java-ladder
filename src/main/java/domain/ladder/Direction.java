package domain.ladder;

import java.util.Objects;

import static domain.ladder.LadderPointGenerator.generatePoint;
import static java.lang.Boolean.FALSE;

public class Direction {
    private final boolean left;
    private final boolean right;

    public static Direction of(boolean left, boolean right) {
        return DirectionKind.findDirection(left, right).getDirection();
    }

    public Direction(boolean left, boolean right) {
        this.left = left;
        this.right = right;
    }

    public static Direction first(Boolean right) {
        return of(FALSE, right);
    }

    public Direction next(int random) {
        if(this.right)
            return next(FALSE);

        return next(generatePoint(random));
    }

    public Direction next(Boolean nextRight) {
        return of(this.right, nextRight);
    }

    public boolean isLeft() {
        return this.left;
    }

    public boolean isRight() {
        return this.right;
    }

    public Direction last() {
        return of(this.right, FALSE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Direction direction = (Direction) o;
        return left == direction.left &&
                right == direction.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }

    @Override
    public String toString() {
        return "Direction{" +
                "left=" + left +
                ", right=" + right +
                '}';
    }
}
