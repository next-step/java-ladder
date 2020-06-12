package ladder.domain.ladder;

import ladder.domain.ladder.strategy.StairGenerationStrategy;

import java.util.function.Function;

public enum StairState {

    EMPTY(position -> position),
    RIGHT(Position::moveRight),
    LEFT(Position::moveLeft);

    private Function<Position, Position> movePosition;

    StairState(final Function<Position, Position> movePosition) {
        this.movePosition = movePosition;
    }

    public static StairState ofFirstPillar(final StairGenerationStrategy strategy) {
        return createStair(strategy);
    }

    public StairState ofNextPillar(final StairGenerationStrategy strategy) {
        if (isRightLineExist()) {
            return LEFT;
        }
        return createStair(strategy);
    }

    public StairState ofLastPillar() {
        return ofNextPillar(() -> false);
    }

    public boolean isRightLineExist() {
        return this == RIGHT;
    }

    private static StairState createStair(final StairGenerationStrategy strategy) {
        if (strategy.generate()) {
            return RIGHT;
        }
        return EMPTY;
    }

    public Position move(final Position position) {
        return movePosition.apply(position);
    }
}
