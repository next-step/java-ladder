package ladder.domain;

public class Point {

    private final boolean isOnCurrentPosition;

    public Point(boolean isOnCurrentPosition) {
        this.isOnCurrentPosition = isOnCurrentPosition;
    }

    public boolean getIsOnCurrentPosition() {
        return isOnCurrentPosition;
    }
}
