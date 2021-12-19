package nextstep.ladder.domain;

import java.util.Objects;

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

    public boolean isRight() {
        return right == true;
    }

    public boolean isLeft() {
        return left == true;
    }

    public boolean isNone() {
        return right == false && left == false;
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
