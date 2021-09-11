package ladder.domain.position;

import ladder.domain.ladder.LadderSize;
import ladder.exception.InvalidPositionException;

import java.util.List;
import java.util.Objects;

public final class Position {
    private static final int INITIAL_FLOOR = 0;
    private static final int MIN_X = 0;
    private static final int MIN_Y = 0;

    private final int x;
//    private final int y;
    private final LadderSize ladderSize;

//    Position(final int x, final int y, final LadderSize ladderSize) {
//        validate(x, y, ladderSize);
//        this.x = x;
//        this.y = y;
//        this.ladderSize = ladderSize;
//    }

    public Position(final int x, final LadderSize ladderSize) {
        validate2(x, ladderSize);
        this.x = x;
        this.ladderSize = ladderSize;
    }

//    private void validate(final int x, final int y, final LadderSize ladderSize) {
//        if (x < MIN_X || x > ladderSize.getMaxHeightPosition()) {
//            throw new InvalidPositionException(x, MIN_X, ladderSize.getMaxHeightPosition());
//        }
//
//        if (y < MIN_Y || y > ladderSize.getMaxWidthPosition()) {
//            throw new InvalidPositionException(y, MIN_Y, ladderSize.getMaxWidthPosition());
//        }
//    }

    private void validate2(final int x, final LadderSize ladderSize) {
        if (x < MIN_X || x > ladderSize.getMaxHeightPosition()) {
            throw new InvalidPositionException(x, MIN_X, ladderSize.getMaxHeightPosition());
        }
    }

    public Position move(List<Boolean> lines) {
        int leftPos = x - 1;
        int rightPos = x + 1;
        int leftLine = x - 1;
        int rightLine = x;

        if (leftPos >= MIN_X && lines.get(leftLine)) {
            return moveLeft(x);
        } else if (rightPos <= ladderSize.getMaxWidthPosition() && lines.get(rightLine)) {
            return moveRight(x);
        }

        return this;
    }

    private Position moveLeft(int x) {
        return new Position(x - 1, ladderSize);
    }

    private Position moveRight(int x) {
        return new Position(x + 1, ladderSize);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && ladderSize.equals(position.ladderSize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, ladderSize);
    }
}
