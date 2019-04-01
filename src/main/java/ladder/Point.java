package ladder;

import java.util.Random;

public class Point {
    public static final String LINK = "-----";
    public static final String NO_LINK = "     ";
    public static final String POINT = "|";

    public static final Point linkedPoint = new Point(true);
    public static final Point notLinkedPoint = new Point(false);

    private boolean isLinked;

    private Point(boolean isLinked) {
        this.isLinked = isLinked;
    }

    public static Point valueOf(Point previous) {
        if (previous == null) {
            return notLinkedPoint;
        }
        return previous.isLinked ? notLinkedPoint : getRandomLink();
    }

    private static Point getRandomLink() {
        return new Random().nextBoolean() ? linkedPoint : notLinkedPoint;
    }

    public boolean isLinked() {
        return isLinked;
    }

    @Override
    public String toString() {
        return (isLinked ? LINK : NO_LINK) + POINT;
    }
}