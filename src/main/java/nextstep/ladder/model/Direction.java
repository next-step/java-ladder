package nextstep.ladder.model;

import java.util.function.Function;

public enum Direction {

    LEFT(Index::prev),
    RIGHT(Index::next),
    PASS(index -> index);

    private final Function<Index, Index> expression;

    Direction(Function<Index, Index> expression) {
        this.expression = expression;
    }

    public static Direction of(Index playerIndex, Point point) {
        if (!point.isActive()) {
            return PASS;
        }

        if (playerIndex.isAdjacentRight(point.getIndex())) {
            return RIGHT;
        }

        if (playerIndex.isAdjacentLeft(point.getIndex())) {
            return LEFT;
        }

        return PASS;
    }

    public Index move(Index index) {
        return expression.apply(index);
    }
}
