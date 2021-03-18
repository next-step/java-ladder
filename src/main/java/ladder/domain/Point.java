package ladder.domain;

public class Point {

    private final boolean isFilled;

    public Point(boolean hasLine) {
        this.isFilled = hasLine;
    }

    public static Point emptyPoint() {
        return new Point(false);
    }

    public static Point filledPoint() {
        return new Point(true);
    }

    public boolean isFilled() {
        return isFilled;
    }
}
