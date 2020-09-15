package ladder.refactoring.domain;

import java.util.Objects;

import static ladder.utils.RandomBoolGenerator.generate;

public class Direction {

    private final boolean left;
    private final boolean right;

    public Direction(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException("양방향성을 가질 수 없습니다.");
        }
        this.left = left;
        this.right = right;
    }

    public static Direction of(boolean left, boolean right) {
        return new Direction(left, right);
    }

    public static Direction ofFirst() {
        return new Direction(false, generate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Direction) {
            Direction other = (Direction) obj;
            return (left == other.left) && (right == other.right);
        }
        return false;
    }

    public int orient() {
        return Orientation.next(left, right);
    }

    public Direction next() {
        if (right) {
            return of(true, false);
        }
        return of(false, generate());
    }

    public Direction last() {
        return of(right, false);
    }

    public boolean isRight() {
        return right;
    }
}
