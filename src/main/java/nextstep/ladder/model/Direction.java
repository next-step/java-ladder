package nextstep.ladder.model;

import java.util.function.Consumer;

public enum Direction {

    LEFT(Index::prev),
    RIGHT(Index::next),
    PASS(index -> {});

    private final Consumer<Index> expression;

    Direction(Consumer<Index> expression) {
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
        expression.accept(index);
    }
}
