package ladder;

public class HorizontalLine {
    private static final HorizontalLine LINE_TRUE = new HorizontalLine(true);
    private static final HorizontalLine LINE_FALSE = new HorizontalLine(false);
    private boolean hasLine;

    private HorizontalLine(boolean hasLine) {
        this.hasLine = hasLine;
    }

    public static HorizontalLine of(boolean hasLine) {
        return hasLine ? LINE_TRUE : LINE_FALSE;
    }

    public boolean hasLine() {
        return hasLine;
    }
}
