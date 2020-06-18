package ladder.domain.ladder;

import java.util.Objects;

import static java.lang.Boolean.FALSE;

public class PointDirection {
    private final boolean left;
    private final boolean right;

    public static PointDirection of(boolean left, boolean right) {
        return new PointDirection(left, right);
    }

    public static PointDirection first(Boolean right) {
        return of(FALSE, right);
    }

    private PointDirection(boolean left, boolean right) {
        validateDirection(left, right);
        this.left = left;
        this.right = right;
    }

    public PointDirection next(boolean nextRight) {
        if (this.right) {
            nextRight = FALSE;
        }
        return of(this.right, nextRight);
    }

    public PointDirection last() {
        return of(this.right, FALSE);
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }

    private void validateDirection(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalStateException("왼쪽 오른쪽을 모두 연결할 수 없습니다.");
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
