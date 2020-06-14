package ladder.domain.ladder;

import java.util.Objects;

import static java.lang.Boolean.FALSE;
import static ladder.domain.ladder.RandomGenerator.isMovable;

public class PointDirection {
    private final boolean left;
    private final boolean right;

    private PointDirection(boolean left, boolean right) {
        validteDirection(left, right);
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

    public PointDirection next(boolean nextRight) {
        return of(this.right, nextRight);
    }

    public PointDirection next() {
        if (this.right) {
            return next(FALSE);
        }
        return next(isMovable());
    }

    public static PointDirection of(boolean first, boolean second) {
        return new PointDirection(first, second);
    }

    public static PointDirection first(boolean right) {
        return of(FALSE, right);
    }

    public PointDirection last() {
        return of(this.right, FALSE);
    }

    private void validteDirection(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalStateException("입력된 방향이 없습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PointDirection pair = (PointDirection) o;
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
