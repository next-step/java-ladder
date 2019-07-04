package ladder.domain;

public class Line {
    private static final Line LINE_TRUE = new Line(true);
    private static final Line LINE_FALSE = new Line(false);
    private boolean hasLine;

    private Line(boolean hasLine) {
        this.hasLine = hasLine;
    }

    public static Line of(boolean hasLine) {
        return hasLine ? LINE_TRUE : LINE_FALSE;
    }

    public boolean hasLine() {
        return hasLine;
    }
}
