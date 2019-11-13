package game.ladder.domain;

import java.util.Arrays;
import java.util.function.IntUnaryOperator;

import static java.util.function.IntUnaryOperator.identity;

/**
 * Created by yusik on 2019/11/13.
 */
public enum Direction {

    LEFT(position -> position - 1, (left, right) -> left && !right),
    RIGHT(position -> position + 1, (left, right) -> !left && right),
    STAY(identity(), (left, right) -> !(left || right)),
    ;

    private final IntUnaryOperator operator;
    private final DirectionPredicate predicate;

    Direction(IntUnaryOperator operator, DirectionPredicate predicate) {
        this.operator = operator;
        this.predicate = predicate;
    }

    public int move(int position) {
        return operator.applyAsInt(position);
    }

    public static Direction getDirection(boolean left, boolean right) {
        return Arrays.stream(values())
                .filter(direction -> direction.predicate.test(left, right))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
