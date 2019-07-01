package ladder;

public class VerticalLine {
    private final int height;
    private HorizontalLine leftHorizontalLine;

    public VerticalLine(int height, boolean hasLeftHorizontalLine) {
        this.height = height;
        this.leftHorizontalLine = hasLeftHorizontalLine
                ? HorizontalLine.LINE_TRUE
                : HorizontalLine.LINE_FALSE;
    }

    public int getHeight() {
        return height;
    }

    public boolean hasLeftHorizontalLine() {
        return leftHorizontalLine.hasLine();
    }

    public HorizontalLine getLeftHorizontalLine() {
        return leftHorizontalLine;
    }
}
