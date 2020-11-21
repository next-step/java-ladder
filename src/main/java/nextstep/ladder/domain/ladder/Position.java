package nextstep.ladder.domain.ladder;

public class Position {
    private static final int MIN_POSITOIN = 0;
    private static final int POSITION_DIFF = 1;

    private final int currentPosition;
    private final int maxPosition;

    public Position(int currentPosition, int maxPosition) {
        this.currentPosition = currentPosition;
        this.maxPosition = maxPosition;
    }

    public Position last() {
        return new Position(maxPosition, maxPosition);
    }

    public static Position of(int currentPosition, int maxPosition) {
        validatePosition(currentPosition, maxPosition);
        return new Position(currentPosition, maxPosition);
    }

    public static Position first(int maxPosition) {
        return of(MIN_POSITOIN, maxPosition);
    }

    private static void validatePosition(int currentPosition, int maxPosition) {
        if (currentPosition < MIN_POSITOIN || currentPosition > maxPosition) {
            throw new InvalidPointPositionException();
        }
    }

    public Position next() {
        return new Position(currentPosition + POSITION_DIFF, maxPosition);
    }

    public boolean isLast() {
        return currentPosition == maxPosition;
    }

    public int getPreviousPosition() {
        return currentPosition - POSITION_DIFF;
    }

    public int getNextPosition() {
        return currentPosition + POSITION_DIFF;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }
}
