package ladder;

import java.util.List;
import java.util.Optional;

public class VerticalLines {
    private final List<VerticalLine> verticalLines;

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

    public VerticalLine getRightLine(VerticalLine verticalLine) {
        return Optional.ofNullable(getLine(verticalLine.getLineNo() + 1))
                .orElse(null);
    }

    public VerticalLine getLeftLine(VerticalLine verticalLine) {
        return Optional.ofNullable(getLine(verticalLine.getLineNo() - 1))
                .orElse(null);
    }
}
