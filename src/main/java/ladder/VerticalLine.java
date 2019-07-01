package ladder;

public class VerticalLine {
    private final int length;
    private HorizontalLine leftHorizontalLine;

    public VerticalLine(int length, boolean hasLeftHorizontalLine) {
        this.length = length;
        this.leftHorizontalLine = hasLeftHorizontalLine
                ? HorizontalLine.LINE_TRUE
                : HorizontalLine.LINE_FALSE;
    }

    public int getLength() {
        return length;
    }

    public boolean hasLeftHorizontalLine() {
        return leftHorizontalLine.hasLine();
    }
}
