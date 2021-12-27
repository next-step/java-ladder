package nextstep.ladder.domain;

import java.util.Objects;

import static nextstep.ladder.domain.Point.RANDOM;

public class Direction {
    private boolean left;
    private boolean right;

    public Direction(String input) {
        if (input.equals("left")) {
            this.left = true;
            this.right = false;
        }
        if (input.equals("right")) {
            this.left = false;
            this.right = true;
        }
        if (input.equals("none")) {
            this.left = false;
            this.right = false;
        }
    }

    public Direction(boolean left, boolean right) {
        this.left = left;
        this.right = right;
    }

    public static Direction of(String input) {
        return new Direction(input);
    }

    public static Direction of(boolean left, boolean right) {
        if (left == true && right == true) {
            throw new IllegalStateException("direction can't be (true, true)");
        }
        return new Direction(left, right);
    }

    public static Direction first() {
        return Direction.of(false, RANDOM.nextBoolean());
    }

    public static Direction first(boolean value) {
        return Direction.of(false, value);
    }

    public Direction last() {
        if (this.right == true && this.left == false) {
            return Direction.of(true, false);
        }
        if (!(this.right == true && this.left == false)) {
            return Direction.of(false, false);
        }
        throw new IllegalArgumentException("lastPointDirection error");
    }

    public boolean isRight() {
        return right == true;
    }

    public boolean isLeft() {
        return left == true;
    }

    public Direction next() {
        if (this.right == true) {
            return Direction.of(true, false);
        }
        if (this.right == false) {
            return Direction.of(false, RANDOM.nextBoolean());
        }
        throw new IllegalArgumentException("Direction next error");
    }

    public Direction next(boolean nextRight) {
        if (nextRight == true) {
            return Direction.of(false, true);
        }
        if (nextRight == false) {
            return Direction.of(false, false);
        }
        throw new IllegalArgumentException("Direction next error");
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

    @Override
    public String toString() {
        return "Direction{" +
                "left=" + left +
                ", right=" + right +
                '}';
    }
}
