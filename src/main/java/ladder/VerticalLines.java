package ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VerticalLines {
    private final List<VerticalLine> verticalLines;

    public VerticalLines(List<VerticalLine> verticalLines) {
        this.verticalLines = verticalLines;
    }

    public List<VerticalLine> getVerticalLines(){
        return new ArrayList<>(this.verticalLines);
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

    public void drawSideLine(VerticalLine verticalLine, int height){
        VerticalLine rightVerticalLine = getRightLine(verticalLine);
        verticalLine.addPoint(height, rightVerticalLine.getLineNo());
        rightVerticalLine.addPoint(height, verticalLine.getLineNo());
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
