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

    public static Direction ofPlayerAndPoint(Player player, Point point) {
        Index subtractIndex = player.getIndex().subtract(point);

        if (Index.ONE_INDEX.equals(subtractIndex)) {
            return LEFT;
        }
        if (Index.ZERO_INDEX.equals(subtractIndex)) {
            return RIGHT;
        }

        return PASS;
    }

    public Index move(Index index) {
        return expression.apply(index);
    }
}
