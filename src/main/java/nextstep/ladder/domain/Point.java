package nextstep.ladder.domain;

import java.util.Objects;

public class Point {
    private static final int MIN_INDEX = 0;

    private final int index;
    private final boolean left;
    private final boolean right;

    public Point(int index, boolean left, boolean right) {
        validate(index);
        validate(left, right);
        this.index = index;
        this.left = left;
        this.right = right;
    }

    private void validate(int index) {
        if (index < MIN_INDEX) {
            throw new IllegalArgumentException("인덱스는 " + MIN_INDEX + "보다 작을 수 없습니다.");
        }
    }

    private void validate(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException("좌 우 모두 이동 가능한 Point 생성 불가");
        }
    }

    public static Point createLeftmost(boolean canMoveRight) {
        return new Point(MIN_INDEX, false, canMoveRight);
    }

    public Point createRightmost() {
        return new Point(this.index + 1, this.right, false);
    }

    public Point createNext(boolean canMoveRight) {
        return new Point(this.index + 1, this.right, !this.right && canMoveRight);
    }

    public boolean canMoveLeft() {
        return left;
    }

    public boolean canMoveRight() {
        return right;
    }

    public boolean sameIndex(int index) {
        return this.index == index;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return index == point.index && left == point.left && right == point.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, left, right);
    }
}
