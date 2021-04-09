package nextstep.ladder.hint;

import java.util.Objects;

import static java.lang.Boolean.FALSE;
import static nextstep.ladder.generator.RandomValueGenerator.generatePoint;

public class HintDirection {
    private final boolean left;
    private final boolean right;

    private HintDirection(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalStateException();
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

    public HintDirection next(boolean nextRight) {
        return of(this.right, nextRight);
    }

    public HintDirection next() {
        if (this.right) {
            return next(FALSE);
        }
        return next(generatePoint());
    }

    public static HintDirection of(boolean first, boolean second) {
        return new HintDirection(first, second);
    }

    public static HintDirection first(boolean right) {
        return of(FALSE, right);
    }

    public HintDirection last() {
        return of(this.right, FALSE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HintDirection)) return false;
        final HintDirection pair = (HintDirection) o;
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
