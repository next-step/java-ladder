package my.project.step4.domain;

import java.util.Objects;

import static my.project.step4.domain.LadderPointGenerator.generatePoint;

/**
 * Created : 2020-12-11 오전 11:23
 * Developer : Seo
 */
public class Direction {
    private final boolean left;
    private final boolean right;

    public static Direction first(Bridge connectedOrNone) {
        return of(Bridge.NONE, connectedOrNone);
    }

    public static Direction of(Bridge left, Bridge rightOrNone) {
        return new Direction(left, rightOrNone);
    }

    private Direction(Bridge left, Bridge right) {
        if (left.value() && right.value()) {
            throw new IllegalStateException();
        }
        this.left = left.value();
        this.right = right.value();
    }

    public Direction next() {
        if (isPreviousRight()) {
            return next(Bridge.NONE);
        }
        return next(generatePoint());
    }

    private boolean isPreviousRight() {
        return this.right;
    }

    public Direction next(Bridge nextRight) {
        return of(previousRight(), nextRight);
    }

    private Bridge previousRight() {
        return this.right ? Bridge.CONNECTED : Bridge.NONE;
    }

    public boolean isRight() {
        return this.right;
    }

    public boolean isLeft() {
        return this.left;
    }

    public Direction last() {
        return of(previousRight(), Bridge.NONE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Direction pair = (Direction) o;
        return left == pair.left &&
                right == pair.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }

    @Override
    public String toString() {
        return right ? Bridge.CONNECTED.getSymbol() : Bridge.NONE.getSymbol();
    }
}
