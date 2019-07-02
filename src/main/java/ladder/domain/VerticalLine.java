package ladder.domain;

public class VerticalLine {
    private HorizontalLine leftHorizontalLine;

    public VerticalLine(boolean hasLeftHorizontalLine) {
        this.leftHorizontalLine = HorizontalLine.of(hasLeftHorizontalLine);
    }

    public boolean hasLeftHorizontalLine() {
        return leftHorizontalLine.hasLine();
    }

    public HorizontalLine getLeftHorizontalLine() {
        return leftHorizontalLine;
    }
}
