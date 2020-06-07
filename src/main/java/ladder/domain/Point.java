package ladder.domain;

public class Point {

    private static final int RANDOM_NUMBER_BOUNDARY = 5;
    private final boolean isExisting;

    public Point(boolean isExisting) {
        this.isExisting = isExisting;
    }

    public static Point drawPoint(int randomNumber) {
        if (randomNumber < RANDOM_NUMBER_BOUNDARY) {
            return new Point(false);
        }
        return new Point(true);
    }

    public boolean getIsExisting() {
        return isExisting;
    }
}
