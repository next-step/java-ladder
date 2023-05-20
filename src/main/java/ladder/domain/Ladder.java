package ladder.domain;

import ladder.exception.UnableReachLineCount;

import java.util.HashSet;
import java.util.Set;

public class Ladder {
    private static final int INFINITE_LOOP_THRESHOLD = 10000;

    private final Set<Line> lines;

    private Ladder() {
        this.lines = new HashSet<>();
    }

    public Ladder(Set<Line> lines) {
        this.lines = lines;
    }

    public static Ladder of(int column, int row) {
        return Ladder.of(column, row, createLineCount(column, row));
    }

    private static int createLineCount(int column, int row) {
        int count = ((column - 1) / 2) * row;
        System.out.printf("사다리 Line 은 %d 개 만듭니다%s", count, System.lineSeparator());
        return count;
    }

    public static Ladder of(int column, int row, int count) {
        Ladder ladder = new Ladder();
        for (int i = 0; ladder.lineCount() < count; i++) {
            infiniteLoopWatchDog(i);
            appendLine(ladder, Line.any(LineStrategyRandom.ofLimit(column, row)));
        }
        return ladder;
    }

    private static void infiniteLoopWatchDog(int i) {
        if (i > INFINITE_LOOP_THRESHOLD) {
            throw new UnableReachLineCount();
        }
    }

    private static void appendLine(Ladder ladder, Line anyLine) {
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
