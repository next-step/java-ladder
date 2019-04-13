package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.lang.Boolean.FALSE;

public class Direction {
    private static final List<Direction> directions = new ArrayList<>();
    private static final int CENTER = 0;
    private static final int RIGHT = 1;
    private static final int LEFT = 2;
    private final boolean left;
    private final boolean right;

    static {
        directions.add(new Direction(DirectionType.CENTER));
        directions.add(new Direction(DirectionType.RIGHT));
        directions.add(new Direction(DirectionType.LEFT));
    }

    private Direction(boolean left, boolean right) {
        if(left && right) {
            throw new IllegalStateException();
        }
        this.left = left;
        this.right = right;
    }

    private Direction(DirectionType directionType) {
        this.left = directionType.isLeft();
        this.right = directionType.isRight();
        if(left && right) {
            throw  new IllegalStateException();
        }
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }

    public boolean isCenter() {
        return !left && !right;
    }

    public Direction next(boolean nextRight) {
        return of(this.right, nextRight);
    }

    public Direction next(BooleanGenerator booleanGenerator) {
        if(this.right) {
            return next(FALSE);
        }

        return next(booleanGenerator.generatePoint());
    }

    public static Direction of(boolean first, boolean second) {
        if(!first && !second) {
            return directions.get(CENTER);
        }
        if(!first && second) {
            return directions.get(RIGHT);
        }
        if(first && !second) {
            return directions.get(LEFT);
        }
        return new Direction(first, second);
    }

    public static Direction first(boolean right) {
        return of(FALSE, right);
    }

    public Direction last() {
        return of(this.right, FALSE);
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if((o == null) || getClass() != o.getClass()) return false;
        Direction pair = (Direction) o;
        return left == pair.left && right == pair.right;
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
