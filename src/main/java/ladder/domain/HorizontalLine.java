package ladder.domain;

import ladder.exception.IllegalHorizontalLineHeightException;

public class HorizontalLine {
    static final int MINIMUM_HEIGHT = 0;

    private final AdjacentVerticalLines adjacentVerticalLines;
    private final int height;

    public HorizontalLine(AdjacentVerticalLines adjacentVerticalLines, int height) {
        checkHeight(height);

        this.adjacentVerticalLines = adjacentVerticalLines;
        this.height = height;
    }

    private void checkHeight(int height) {
        if (height < MINIMUM_HEIGHT) {
            throw new IllegalHorizontalLineHeightException(String.format("최소 높이 : %d", MINIMUM_HEIGHT));
        }
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
