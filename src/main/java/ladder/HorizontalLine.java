package ladder;

public class HorizontalLine {
    public static final HorizontalLine LINE_TRUE = new HorizontalLine(true);
    public static final HorizontalLine LINE_FALSE = new HorizontalLine(false);
    private boolean hasLine;

    private HorizontalLine(boolean hasLine) {
        this.hasLine = hasLine;
    }

    public boolean hasLine() {
        return hasLine;
    }
}
