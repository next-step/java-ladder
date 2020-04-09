package ladder.domain;

import ladder.drawable.Drawable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class VerticalLines {
    private final List<VerticalLine> verticalLines;

    public VerticalLines(int lineCount) {
        this.verticalLines = drawVerticalLines(lineCount);
    }

    public VerticalLines(List<VerticalLine> verticalLines) {
        this.verticalLines = verticalLines;
    }

    public VerticalLine getLine(int index) {
        return verticalLines.stream()
                .filter(v -> v.getLineNo() == index)
                .findFirst()
                .orElseGet(null);
    }

    public int getSize() {
        return this.verticalLines.size();
    }

    public void drawSideLines(int height, Drawable drawable) {
        int verticalLinesSize = verticalLines.size();
        for (int i = 1; i < verticalLinesSize; i++) {
            VerticalLine verticalLine = getLine(i);
            IntStream.rangeClosed(1, height)
                    .forEach(h -> drawSideLine(verticalLine, h, drawable));
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
        IntStream.rangeClosed(1, lineCount)
                .forEach(c -> verticalLines.add(new VerticalLine(c)));

        return verticalLines;
    }
}
