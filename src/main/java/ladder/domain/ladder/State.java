package ladder.domain.ladder;

import ladder.domain.ladder.strategy.StairGenerationStrategy;

import java.util.function.Function;

public enum State {

    EMPTY(position -> position),
    RIGHT(position -> position + 1),
    LEFT(position -> position - 1);

    private Function<Integer, Integer> movePosition;

    State(final Function<Integer, Integer> movePosition) {
        this.movePosition = movePosition;
    }

    public static State ofFirstPillar(final StairGenerationStrategy strategy) {
        return createStair(strategy);
    }

    public State ofNextPillar(final StairGenerationStrategy strategy) {
        if (isExistLine()) {
            return LEFT;
        }
        return createStair(strategy);
    }

    public State ofLastPillar() {
        if (isExistLine()) {
            return LEFT;
        }
        return EMPTY;
    }

    public boolean isExistLine() {
        return this == RIGHT;
    }

    private static State createStair(final StairGenerationStrategy strategy) {
        if (strategy.generate()) {
            return RIGHT;
        }
        return EMPTY;
    }

    public int move(final int position) {
        return movePosition.apply(position);
    }
}
