package ladder;

public class VerticalLine {
    private final int length;
    private HorizontalLine horizontalLine;

    public VerticalLine(int length, boolean hasHorizontalLine) {
        this.length = length;
        this.horizontalLine = hasHorizontalLine
                ? HorizontalLine.LINE_TRUE
                : HorizontalLine.LINE_FALSE;
    }

    public int getLength() {
        return length;
    }

    public boolean hasHorizontalLine() {
        return horizontalLine.hasLine();
    }
}
