package ladder.domain;

import ladder.exception.UnableReachLineCount;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Ladder {
    private static final int INFINITE_LOOP_THRESHOLD = 10000;

    private final Column maxColumn;
    private final Row maxRow;
    private final Set<Line> lines;

    public Ladder(Column maxColumn, Row maxRow, Set<Line> lines) {
        this.maxColumn = maxColumn;
        this.maxRow = maxRow;
        this.lines = lines;
    }

    public static Ladder of(Set<Line> lines) {
        return new Ladder(
                Column.of(lines.stream().map(line -> line.getColumn().getValue()).max(Comparator.naturalOrder()).orElseThrow()),
                Row.of(lines.stream().map(line -> line.getRow().getValue()).max(Comparator.naturalOrder()).orElseThrow()),
                lines
        );
    }

    public static Ladder of(int column, int row) {
        Random random = new Random();
        Ladder ladder = new Ladder(Column.of(column), Row.of(row), new HashSet<>());
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (random.nextInt(100) > 50) {
                    Line line = new Line(j, i);
                    if (ladder.isPossibilAddingLine(line)) {
                        ladder.append(line);

                    }
                }
            }
        }
        return ladder;
    }

    private boolean isPossibilAddingLine(Line line) {
        return !this.hasCrossIntersection(line) &&
                this.isEdgeExceeded(line);
    }

    private boolean isEdgeExceeded(Line line) {
        return this.maxColumn.isGraterThan(line.getColumn());
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
