package ladder.domain;

public class Point {

    private final int x;

    private final boolean hasLine;

    public Point(int x, boolean hasLine) {
        this.x = x;
        this.hasLine = hasLine;
    }

    public static Point emptyPoint(int x) {
        this(x, false);
    }
}
