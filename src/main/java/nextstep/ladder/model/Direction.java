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

    public static Direction of(Player player, Point point) {
        if (!point.isActive()) {
            return PASS;
        }
        Index playerIndex = player.getIndex();

        if (playerIndex.isAdjacentRight(point)) {
            return RIGHT;
        }

        if (playerIndex.isAdjacentLeft(point)) {
            return LEFT;
        }

        return PASS;
    }

    public void move(Index index) {
        expression.apply(index);
    }
}
