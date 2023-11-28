package ladder.domain;

import java.util.Objects;

public class Coordinate {

    private static final Coordinate LEFT = new Coordinate(true, false);
    private static final Coordinate RIGHT = new Coordinate(false, true);
    private static final Coordinate DONT_MOVE = new Coordinate(false, false);

    private final Location left;
    private final Location right;


    public Coordinate(boolean left, boolean right) {
        this.left = Location.valueOf(left);
        this.right = Location.valueOf(right);

    }

    public static Coordinate of(boolean left, boolean right) {
        if (left) {
            return LEFT;
        }
        if (right) {
            return RIGHT;
        }
        return DONT_MOVE;
    }

    public static Coordinate first(boolean right) {
        return Coordinate.of(false, right);
    }

    public static Coordinate end(boolean left) {
        return Coordinate.of(left, false);
    }

    public Coordinate next(boolean left, boolean right) {
        return Coordinate.of(left, right);
    }

    public boolean isLeft() {
        return left.exist();
    }

    public boolean isRight() {
        return right.exist();
    }

    public int move() {
        if (left.exist()) {
            return Direction.LEFT.move();
        }
        if (right.exist()) {
            return Direction.RIGHT.move();
        }
        return Direction.DONT.move();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return left == that.left && right == that.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }

    @Override
    public String toString() {
        return left + " : " + right;
    }
}
