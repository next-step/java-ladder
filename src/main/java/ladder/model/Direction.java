package ladder.model;

import java.util.EnumSet;
import java.util.function.Function;

public enum Direction {

    RIGHT(false, true, position -> new Position(position.getValue() + 1)),
    LEFT(true, false, position -> new Position(position.getValue() - 1)),
    PASS(false, false, position -> new Position(position.getValue()));

    private final boolean left;
    private final boolean right;
    private final Function<Position, Position> expression;

    Direction(boolean left, boolean right, Function<Position, Position> expression) {
        this.left = left;
        this.right = right;
        this.expression = expression;
    }

    public static Direction of(boolean left, boolean right) {
        return EnumSet.allOf(Direction.class).stream()
                .filter(Direction -> Direction.left == left && Direction.right == right)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("연속된 Direction은 만들수 없습니다"));
    }

    public Position move(final Position position) {
        return expression.apply(position);
    }
}
