package step4.domain.ladder;

import java.util.Objects;
import step4.strategy.DirectionGenerateStrategy;

public class Direction {

    private static final boolean DISCONNECT = false;
    private static final boolean CONNECT = true;

    private final boolean left;
    private final boolean right;

    private Direction(boolean left, boolean right) {
        this.left = left;
        this.right = right;
    }

    static Direction from(boolean left, boolean right) {
        return new Direction(left, right);
    }

    public static Direction first(DirectionGenerateStrategy strategy) {
        return new Direction(DISCONNECT, strategy.generateDirection());
    }

    public Direction next(DirectionGenerateStrategy strategy) {
        if (right) {
            return new Direction(right, DISCONNECT);
        }
        return new Direction(right, strategy.generateDirection());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Direction direction = (Direction) o;
        return left == direction.left && right == direction.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }
}
