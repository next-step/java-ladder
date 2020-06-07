package ladder.domain;

public class Point {

    private static final int RANDOM_NUMBER_BOUNDARY = 5;
    private final boolean isOnCurrentPosition;

    public Point(boolean isOnCurrentPosition) {
        this.isOnCurrentPosition = isOnCurrentPosition;
    }

    public static Point of(int randomNumber) {
        if (randomNumber < RANDOM_NUMBER_BOUNDARY) {
            return new Point(false);
        }
        return new Point(true);
    }

    public boolean getIsOnCurrentPosition() {
        return isOnCurrentPosition;
    }
}
