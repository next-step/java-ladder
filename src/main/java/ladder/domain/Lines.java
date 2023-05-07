package ladder.domain;

import java.util.HashSet;
import java.util.Set;

public class Lines {
    private final Set<Line> lines;

    private Lines() {
        this.lines = new HashSet<>();
    }
    public static Lines of(int height, int width, int count) {
        Lines lines = new Lines();
        while (lines.lineCount() <= count) {
            Line anyLine = Line.any(LineStrategyRandom.of(height, width));

            if (lines.isExistSameColumnAndAdjacentRow(anyLine)) {
                lines.append(anyLine);
            }
        }
        return lines;
    }

    private void append(Line anyLine) {
        this.lines.add(anyLine);
    }

    private boolean isExistSameColumnAndAdjacentRow(Line otherLine) {
       return !this.lines.stream()
               .filter(line -> line.isSameColum(otherLine))
               .filter(line -> line.isAdjacentRow(otherLine))
               .findFirst().isPresent();
    }

    public int lineCount() {
        return this.lines.size();
    }

    public Set<Line> allLines() {
        return lines;
    }

    public boolean existLine(int columnIndex, int rowIndex) {
        return lines.stream().filter(line -> line.isYourPosition(columnIndex, rowIndex)).findFirst().isPresent();
    }
}
