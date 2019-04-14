package ladder.domain;

public class Point {
    public static final String LINK = "-----";
    public static final String NO_LINK = "     ";
    public static final String POINT = "|";

    private final int index;
    private final LinkedType linkedType;

    public Point(int index, LinkedType linkedType) {
        this.index = index;
        this.linkedType = linkedType;
    }

    public static Point getFirst() {
        return new Point(0, LinkedType.first());
    }

    public static Point valueOf(Point previous) {
        return new Point(previous.index + 1, previous.linkedType.next());
    }

    public static Point getLast(Point previous) {
        return new Point(previous.index + 1, previous.linkedType.last());
    }

    public int move() {
        if (this.linkedType.isLeftLinked()) {
            return index - 1;
        }
        if (this.linkedType.isRightLinked()) {
            return index + 1;
        }
        return index;
    }

    public boolean isLeftLinked() {
        return this.linkedType.isLeftLinked();
    }

    public boolean isRightLinked() {
        return this.linkedType.isRightLinked();
    }

    @Override
    public String toString() {
        return (this.linkedType.isLeftLinked() ? LINK : NO_LINK) + POINT;
    }
}
