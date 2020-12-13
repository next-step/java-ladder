package ladder.domain;

import java.util.Objects;

public class Pointer {

    private static final String SAME_TRUE_TYPE = "두 상태값이 True 일 수 없습니다";

    private final boolean left;
    private final boolean right;

    private Pointer(boolean left, boolean right) {
        checkSameBoolean(left,right);
        this.left = left;
        this.right = right;
    }

    private void checkSameBoolean(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalStateException(SAME_TRUE_TYPE);
        }
    }

    public static Pointer of(boolean left, boolean right) {
        return new Pointer(left,right);
    }

    public static Pointer next(Pointer pointer, boolean next) {
        return of(pointer.isRight(),next);
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pointer pointer = (Pointer) o;
        return left == pointer.left && right == pointer.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }
}
