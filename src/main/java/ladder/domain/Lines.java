package ladder.domain;

import ladder.control.Preferences;
import ladder.exception.UnableReachLineCount;

import java.util.HashSet;
import java.util.Set;

public class Lines {
    private final Set<Line> lines;

    private Lines() {
        this.lines = new HashSet<>();
    }

    public static Lines of(int column, int row, int count) {
        Lines lines = new Lines();
        for (int i = 0; lines.lineCount() < count; i++) {
            addLineSuitableOnly(lines, Line.any(LineStrategyRandom.ofLimit(column, row)));
            addLineInfiniteLoopWatchDog(i);
        }
        return lines;
    }

    private static void addLineInfiniteLoopWatchDog(int i) {
        if(i> Preferences.circuitBreakerTriggerLoopCount()) {
            throw new UnableReachLineCount();
        }
    }

    private static void addLineSuitableOnly(Lines lines, Line anyLine) {
        if (lines.isExistSameColumnAndAdjacentRow(anyLine)) {
            lines.append(anyLine);
        }
    }

    private void append(Line anyLine) {
        this.lines.add(anyLine);
    }

    private boolean isExistSameColumnAndAdjacentRow(Line otherLine) {
        return this.lines.stream()
                .filter(line -> line.isSameRow(otherLine))
                .noneMatch(line -> line.isAdjacentColumn(otherLine));
    }

    public int lineCount() {
        return this.lines.size();
    }

    public Set<Line> allLines() {
        return lines;
    }

    public boolean existLine(int columnIndex, int rowIndex) {
        return lines.stream().filter(line -> line.isExisit(columnIndex, rowIndex)).findFirst().isPresent();
    }
}
