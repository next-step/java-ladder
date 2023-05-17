package ladder.domain;

import ladder.exception.IllegalAdjacentVerticalLinesException;

public class AdjacentVerticalLines {
    private final VerticalLine leftVerticalLine;
    private final VerticalLine rightVerticalLine;

    public AdjacentVerticalLines(VerticalLine firstVerticalLine, VerticalLine secondVerticalLine) {
        checkAdjacentVerticalLines(firstVerticalLine, secondVerticalLine);

        this.leftVerticalLine = min(firstVerticalLine, secondVerticalLine);
        this.rightVerticalLine = max(firstVerticalLine, secondVerticalLine);
    }

    public VerticalLine getLeftVerticalLine() {
        return leftVerticalLine;
    }

    public VerticalLine getRightVerticalLine() {
        return rightVerticalLine;
    }

    private void checkAdjacentVerticalLines(VerticalLine firstVerticalLine, VerticalLine secondVerticalLine) {
        if (Math.abs(firstVerticalLine.getIndex() - secondVerticalLine.getIndex()) > 1) {
            throw new IllegalAdjacentVerticalLinesException(
                    String.format("입력된 인덱스 : %d, %d", firstVerticalLine.getIndex(), secondVerticalLine.getIndex())
            );
        }
    }

    private VerticalLine max(VerticalLine firstVerticalLine, VerticalLine secondVerticalLine) {
        return firstVerticalLine.getIndex() > secondVerticalLine.getIndex()
                ? firstVerticalLine
                : secondVerticalLine;
    }

    private VerticalLine min(VerticalLine firstVerticalLine, VerticalLine secondVerticalLine) {
        return firstVerticalLine.getIndex() > secondVerticalLine.getIndex()
                ? secondVerticalLine
                : firstVerticalLine;
    }
}
