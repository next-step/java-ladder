package ladder;

public class VerticalLine {
    private HorizontalLine leftHorizontalLine;

    public VerticalLine(boolean hasLeftHorizontalLine) {
        this.leftHorizontalLine = hasLeftHorizontalLine
                ? HorizontalLine.LINE_TRUE
                : HorizontalLine.LINE_FALSE;
    }

    public boolean hasLeftHorizontalLine() {
        return leftHorizontalLine.hasLine();
    }

    public HorizontalLine getLeftHorizontalLine() {
        return leftHorizontalLine;
    }
}
