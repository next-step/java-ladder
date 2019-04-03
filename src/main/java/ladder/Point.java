package ladder;

import java.util.Random;

public class Point {
    public static final String LINK = "-----";
    public static final String NO_LINK = "     ";
    public static final String POINT = "|";

    public static final Point onlyLeftLinkedPoint = new Point(true, false);
    public static final Point onlyRightLinkedPoint = new Point(false, true);
    public static final Point neitherLinkedPoint = new Point(false, false);

    private boolean leftLink;
    private boolean rightLink;

    private Point(boolean leftLink, boolean rightLink) {
        this.leftLink = leftLink;
        this.rightLink = rightLink;
    }

    public static Point valueOf(Point previous) {
        if (previous == null || !previous.rightLink) {
            return new Random().nextBoolean() ? onlyRightLinkedPoint : neitherLinkedPoint;
        }
        return onlyLeftLinkedPoint;
    }

    public static Point getRightNotLinked(Point previous) {
        return previous.rightLink ? onlyLeftLinkedPoint : neitherLinkedPoint;
    }

    public boolean isLeftLinked() {
        return leftLink;
    }

    public boolean isRightLinked() {
        return rightLink;
    }

    @Override
    public String toString() {
        return (isLeftLinked() ? LINK : NO_LINK) + POINT;
    }
}