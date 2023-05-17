package ladder.domain;

import ladder.exception.ContinuousHorizontalLineException;
import ladder.exception.NotEnoughVerticalLinesException;

import java.util.Set;

public class Ladder {
    private static final int MINIMUM_VERTICAL_LINES_QUANTITY = 2;

    private final VerticalLines verticalLines;
    private final HorizontalLines horizontalLines;

    public Ladder(VerticalLines verticalLines, HorizontalLines horizontalLines) {
        checkVerticalLines(verticalLines);
        checkValidLines(verticalLines, horizontalLines);

        this.verticalLines = verticalLines;
        this.horizontalLines = horizontalLines;
    }

    private void checkVerticalLines(VerticalLines verticalLines) {
        if (verticalLines.getSize() < MINIMUM_VERTICAL_LINES_QUANTITY) {
            throw new NotEnoughVerticalLinesException(String.format("세로선 갯수 : %d", verticalLines.getSize()));
        }
    }

    private void checkValidLines(VerticalLines verticalLines, HorizontalLines horizontalLines) {
        for (int i = 0; i < horizontalLines.getMaxHeight(); i++) {
            Set<HorizontalLine> horizontalLineSet = horizontalLines.getHorizontalLineSetByHeight(i);
            checkExistContinuousHorizontalLinesOnSameHeight(verticalLines, horizontalLineSet);
        }
    }

    private void checkExistContinuousHorizontalLinesOnSameHeight(VerticalLines verticalLines, Set<HorizontalLine> horizontalLineSet) {
        verticalLines.getVerticalLineSet()
                .forEach(verticalLine ->
                        checkConnectingWithManyHorizontalLines(verticalLine, horizontalLineSet)
                );
    }

    private void checkConnectingWithManyHorizontalLines(VerticalLine verticalLine, Set<HorizontalLine> horizontalLineSet) {
        if (horizontalLineSet.stream()
                .filter(it -> it.isConnected(verticalLine))
                .count() > 1
        ) {
            throw new ContinuousHorizontalLineException(String.format("중복되는 세로선 위치 : %d", verticalLine.getIndex()));
        }
    }

    public int getHeight() {
        return horizontalLines.getMaxHeight();
    }

    public int getWidth() {
        return verticalLines.getMaxWidth();
    }

    public VerticalLines getVerticalLines() {
        return verticalLines;
    }

    public HorizontalLines getHorizontalLines() {
        return horizontalLines;
    }
}
