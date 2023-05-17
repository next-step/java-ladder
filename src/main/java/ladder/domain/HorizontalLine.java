package ladder.domain;

public class HorizontalLine {
    private final AdjacentVerticalLines adjacentVerticalLines;
    private final int height;

    public HorizontalLine(AdjacentVerticalLines adjacentVerticalLines, int height) {
        this.adjacentVerticalLines = adjacentVerticalLines;
        this.height = height;
    }

    public AdjacentVerticalLines getAdjacentVerticalLines() {
        return adjacentVerticalLines;
    }

    public int getHeight() {
        return height;
    }

    public VerticalLine getLeftVerticalLine() {
        return adjacentVerticalLines.getLeftVerticalLine();
    }

    public VerticalLine getRightVerticalLine() {
        return adjacentVerticalLines.getRightVerticalLine();
    }

    public boolean isConnected(VerticalLine verticalLine) {
        return verticalLine == adjacentVerticalLines.getLeftVerticalLine()
                || verticalLine == adjacentVerticalLines.getRightVerticalLine();
    }
}
