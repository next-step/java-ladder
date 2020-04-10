package ladder.model;

import java.util.Objects;

import static java.lang.Boolean.FALSE;
import static ladder.model.PointTdd.generatePoint;

public class DirectionTdd {
    private final boolean left;
    private final boolean right;

    private DirectionTdd(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException();
        }

        this.left = left;
        this.right = right;
        System.out.println(this);
    }

    public boolean isRight() {
        return this.right;
    }

    public boolean isLeft() {
        return this.left;
    }

    public DirectionTdd next(boolean nextRight) {
        return of(this.right, nextRight);
    }

    public DirectionTdd next() {
        if (this.right) {
            return next(FALSE);
        }
        return next(generatePoint());
    }

    public static DirectionTdd of(boolean first, boolean second) {
        return new DirectionTdd(first, second);
    }

    public static DirectionTdd first(boolean right) {
        return of(FALSE, right);
    }

    public DirectionTdd last() {
        return of(this.right, FALSE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DirectionTdd pair = (DirectionTdd) o;
        return left == pair.left &&
                right == pair.right;
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
