package ladder.domain.ladder;

public class Point {
    private final boolean hasLine;

    public Point(boolean hasLine) {
        this.hasLine = hasLine;
    }

    public boolean hasLine() {
        return hasLine;
    }

    public static Point create(boolean previousHasLine) {
        if (previousHasLine) return new Point(false);
        return new Point(Math.random() > 0.5);
    }
}
