package ladder.domain;

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
                .orElse(null);
    }

    public int getSize() {
        return this.verticalLines.size();
    }

    public void drawSideLine(VerticalLine verticalLine, int height) {
        VerticalLine rightVerticalLine = getRightLine(verticalLine);
        if (rightVerticalLine != null) {
            verticalLine.addPoint(height, rightVerticalLine.getLineNo());
            rightVerticalLine.addPoint(height, verticalLine.getLineNo());
        }
    }

    private VerticalLine getRightLine(VerticalLine verticalLine) {
        return Optional.ofNullable(getLine(verticalLine.getLineNo() + 1))
                .orElse(null);
    }

    private List<VerticalLine> drawVerticalLines(int lineCount) {
        List<VerticalLine> verticalLines = new ArrayList<>();
        IntStream.rangeClosed(1, lineCount)
                .forEach(c -> verticalLines.add(new VerticalLine(c)));

        return verticalLines;
    }
}
