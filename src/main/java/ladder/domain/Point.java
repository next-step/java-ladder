package ladder.domain;

import java.util.Random;

public class Point {

    private static final Random random = new Random();

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

    public static Point randomPoint() {
        return new Point(random.nextBoolean());
    }

    public boolean isFilled() {
        return isFilled;
    }
}
