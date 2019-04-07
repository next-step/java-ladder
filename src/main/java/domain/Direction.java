package domain;

import java.util.Objects;

public class Direction {
    private Movable left;
    private Movable right;

    public static Direction LEFT = new Direction(Movable.TRUE, Movable.FALSE);
    public static Direction NONE = new Direction(Movable.FALSE, Movable.FALSE);
    public static Direction RIGHT = new Direction(Movable.FALSE, Movable.TRUE);

    Direction(Movable left, Movable right) {
        if (left.on() && right.on()) {
            throw new IllegalArgumentException();
        }

        this.left = left;
        this.right = right;
    }

    public boolean canMoveLeft() {
        return left.on();
    }

    public boolean canMoveRight() {
        return right.on();
    }

    public static Direction first(Movable right) {
        if (right == Movable.TRUE) {
            return RIGHT;
        }

        return NONE;
    }

    public Direction last() {
        if (right == Movable.TRUE) {
            return LEFT;
        }

        return NONE;
    }

    public Direction next(Movable next) {
        if (right.on() && next.off()) {
            return LEFT;
        }

        if(right.off() && next.off()) {
            return NONE;
        }

        if (right.off() && next.on()) {
            return RIGHT;
        }

        throw new IllegalArgumentException();
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
