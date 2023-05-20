package ladder.domain;

import ladder.control.Preferences;
import ladder.exception.UnableReachLineCount;

import java.util.HashSet;
import java.util.Set;

public class Ladder {
    private final Set<Line> lines;

    private Ladder() {
        this.lines = new HashSet<>();
    }

    public Ladder(Set<Line> lines) {
        this.lines = lines;
    }

    public static Ladder of(int column, int row) {
        return Ladder.of(column, row, Preferences.createLineCount(column, row));
    }

    public static Ladder of(int column, int row, int count) {
        Ladder ladder = new Ladder();
        for (int i = 0; ladder.lineCount() < count; i++) {
            addLineInfiniteLoopWatchDog(i);
            addLineSuitableOnly(ladder, Line.any(LineStrategyRandom.ofLimit(column, row)));
        }
        return ladder;
    }

    private static void addLineInfiniteLoopWatchDog(int i) {
        if (i > Preferences.circuitBreakerTriggerLoopCount()) {
            throw new UnableReachLineCount();
        }
    }

    private static void addLineSuitableOnly(Ladder ladder, Line anyLine) {
        if (!ladder.hasCrossIntersection(anyLine)) {
            ladder.append(anyLine);
        }
    }

    public void append(Line anyLine) {
        this.lines.add(anyLine);
    }

    public boolean hasCrossIntersection(Line otherLine) {
        return lines.stream()
                .filter(line -> line.isSameRow(otherLine))
                .anyMatch(line -> line.isAdjacentColumn(otherLine));
    }

    public int lineCount() {
        return this.lines.size();
    }

    public Set<Line> allLines() {
        return lines;
    }

    public boolean existLine(Line otherLine) {
        return lines.stream().anyMatch(line -> line.isSame(otherLine));
    }
}
