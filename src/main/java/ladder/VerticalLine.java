package ladder;

public class VerticalLine {
    private final int length;
    private HorizontalLine horizontalLine;

    public VerticalLine(int length) {
        this.length = length;
        this.horizontalLine = HorizontalLine.LINE_FALSE;
    }

    public int getLength() {
        return length;
    }

    public boolean hasHorizontalLine() {
        return horizontalLine.hasLine();
    }
}
