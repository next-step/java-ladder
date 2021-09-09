package ladder.domain;

import ladder.exception.InvalidPositionException;

public final class Position {
    private static final int INITIAL_FLOOR = 0;
    private static final int MIN_X = 0;
    private static final int MIN_Y = 0;

    private final int x;
    private final int y;

    Position(final int x, final int y, final LadderSize ladderSize) {
        validate(x, y, ladderSize);
        this.x = x;
        this.y = y;
    }

    Position(final int x, final LadderSize ladderSize) {
        this(x, INITIAL_FLOOR, ladderSize);
    }

    private void validate(final int x, final int y, final LadderSize ladderSize) {
        if (x < MIN_X || x > ladderSize.getMaxHeightPosition()) {
            throw new InvalidPositionException(x, MIN_X, ladderSize.getMaxHeightPosition());
        }

        if (y < MIN_Y || y > ladderSize.getMaxWidthPosition()) {
            throw new InvalidPositionException(y, MIN_Y, ladderSize.getMaxWidthPosition());
        }
    }
}
