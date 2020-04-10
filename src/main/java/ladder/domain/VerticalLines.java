package ladder.domain;

import ladder.drawable.Drawable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VerticalLines {
    private final List<VerticalLine> verticalLines;

    public VerticalLines(int lineCount) {
        this.verticalLines = drawVerticalLines(lineCount);
    }

    public VerticalLines(List<VerticalLine> verticalLines) {
        this.verticalLines = verticalLines;
    }

    public VerticalLine getLine(int no) {
        return verticalLines.stream()
                .filter(v -> v.isLineNumber(no))
                .findFirst()
                .orElseGet(null);
    }

    public int getSize() {
        return this.verticalLines.size();
    }

    public void drawSideLines(int height, Drawable drawable) {
        int verticalLinesSize = verticalLines.size();
        for (int i = 1; i < verticalLinesSize; i++) {
            drawSideLineByHeights(getLine(i), height, drawable);
        }
    }

    private void drawSideLineByHeights(VerticalLine verticalLine, int height, Drawable drawable) {
        for (int i = 1; i <= height; i++) {
            drawSideLine(verticalLine, i, drawable);
        }
    }

    private void drawSideLine(VerticalLine verticalLine, int height, Drawable drawable) {
        if (drawable.isDraw() && !verticalLine.isExistPoint(height)) {
            Optional.ofNullable(getLine(verticalLine.getLineNo() + 1))
                    .ifPresent(rightVerticalLine -> {
                        verticalLine.addPoint(height, rightVerticalLine.getLineNo());
                        rightVerticalLine.addPoint(height, verticalLine.getLineNo());
                    });
        }
    }

    private List<VerticalLine> drawVerticalLines(int lineCount) {
        List<VerticalLine> verticalLines = new ArrayList<>();
        for (int i = 1; i <= lineCount; i++) {
            verticalLines.add(new VerticalLine(i));
        }
        return verticalLines;
    }
}
