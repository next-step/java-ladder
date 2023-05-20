package ladder.domain;

import ladder.exception.UnableReachLineCount;

import java.util.HashSet;
import java.util.Set;
import java.util.prefs.Preferences;

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
            int min = Math.min(canCreateAnyCasePolicy(column, row), defaultLadderCreatePolicy(column));
            System.out.printf("사다리 Line 은 %d 개 만듭니다%s", min, System.lineSeparator());
            return min;
    }

    private static int defaultLadderCreatePolicy(int column) {
            return column * 2 - 1;
    }

    private static int canCreateAnyCasePolicy(int column, int row) {
        return ((column - 1) / 2) * row;
        // 예시에서 참가자 4명, 7개사다리, 높이5 였는데
        // 참가자4명, 높이5 일때, 사다리 7개를 만들지 못하는 경우가 발생함. 이에 무조건 사다리를 만들수 있는 수로만 사다리의 생성을 제한함

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
        if (i > INFINITE_LOOP_THRESHOLD) {
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
