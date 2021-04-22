package ladder.domain;

import java.util.Objects;

public class Direction {
    private final Link left;
    private final Link right;

    private Direction(Link left, Link right) {
        if (left == Link.CLOSE && right == Link.CLOSE) {
            throw new IllegalArgumentException("이전링크와 현재링크 모두 닫혀있을 수 없습니다");
        }

        this.left = left;
        this.right = right;
    }

    public static Direction of(Link left, Link right) {
        return new Direction(left, right);
    }

    public static Direction first(Link right) {
        return of(Link.OPEN, right);
    }

    public static Direction first() {
        return first(RandomLinkSelector.link());
    }

    public Direction last() {
        return of(right, Link.OPEN);
    }

    public Direction next(Link right) {
        return of(this.right, right);
    }

    public Direction next() {
        if (this.right == Link.CLOSE) {
            return of(this.right, Link.OPEN);
        }

        return of(this.right, RandomLinkSelector.link());
    }

    public Link right() {
        return this.right;
    }

    public int move() {
        if (isLeft()) {
            return 0;
        }

        if (isRight()) {
            return 1;
        }

        return 2;
    }

    boolean isStraight() {
        return left == Link.OPEN && right == Link.OPEN;
    }

    boolean isRight() {
        return left == Link.OPEN && right == Link.CLOSE;
    }

    boolean isLeft() {
        return left == Link.CLOSE && right == Link.OPEN;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Direction direction = (Direction) o;
        return left == direction.left && right == direction.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }
}
