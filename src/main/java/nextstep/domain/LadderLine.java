package nextstep.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderLine {
    private static final int WRITE_START = 1;
    private static final int LINE_LENGTH_FOR_USER = 5;
    private static final int MOVE_USER_POINT = 6;
    private static final boolean USER_POINT = false;
    private final List<Boolean> points = new ArrayList<>();
    private List<Boolean> visitedList = new ArrayList<>();

    public LadderLine(List<Boolean> isLadderGenerates) {
        writeLadderLine(isLadderGenerates);
    }

    private void writeLadderLine(List<Boolean> isLadderGenerates) {
        for (int i = WRITE_START; i <= isLadderGenerates.size(); i++) {
            this.points.add(USER_POINT);
            this.visitedList.add(false);
            this.points.addAll(writePoints(i, isLadderGenerates.get(i - 1)));
        }
        this.points.add(USER_POINT);
        this.visitedList.add(false);
    }

    private List<Boolean> writePoints(int i, boolean generate) {
        for (int j = 0; j < LINE_LENGTH_FOR_USER; j++) {
            this.visitedList.add(false);
        }

        if (i == WRITE_START) {
            return write(generate);
        }
        if (!checkPoint(i)) {
            return write(generate);
        }
        return write(false);
    }

    private boolean checkPoint(int i) {
        return this.points.get((i - 1) * LINE_LENGTH_FOR_USER - 1);
    }

    private List<Boolean> write(boolean point) {
        return IntStream.range(0, LINE_LENGTH_FOR_USER)
                .mapToObj(idx -> point)
                .collect(Collectors.toList());
    }

    public int moveLadderLine(int startIndex) {
        if (isLeftStartIndex(startIndex)) {
            return checkRightPoint(startIndex);
        }
        if (isRightStartIndex(startIndex)) {
            return checkLeftPoint(startIndex);
        }
        if (isLeftIndex(startIndex)) {
            visitLeft(startIndex);
            return moveLadderLine(startIndex - MOVE_USER_POINT);
        }
        if (isRightIndex(startIndex)) {
            visitRight(startIndex);
            return moveLadderLine(startIndex + MOVE_USER_POINT);
        }
        clearVisitedList();
        return startIndex;
    }

    private boolean isLeftStartIndex(int startIndex) {
        return startIndex == 0 && !this.visitedList.get(startIndex);
    }

    private boolean isRightStartIndex(int startIndex) {
        return startIndex == this.points.size() - 1 && !this.visitedList.get(startIndex);
    }

    private boolean isLeftIndex(int startIndex) {
        return startIndex > 0 && startIndex < this.points.size() - 1
                && !this.visitedList.get(startIndex - 1)
                && this.points.get(startIndex - 1);
    }

    private boolean isRightIndex(int startIndex) {
        return startIndex > 0 && startIndex < this.points.size() - 1
                && !this.visitedList.get(startIndex + 1)
                && this.points.get(startIndex + 1);
    }


    private int checkLeftPoint(int i) {
        if (!this.visitedList.get(i - 1) && this.points.get(i - 1)) {
            visitLeft(i);
            return moveLadderLine(i - MOVE_USER_POINT);
        }
        clearVisitedList();
        return i;
    }

    private int checkRightPoint(int i) {
        if (!this.visitedList.get(i + 1) && this.points.get(i + 1)) {
            visitRight(i);
            return moveLadderLine(i + MOVE_USER_POINT);
        }
        clearVisitedList();
        return i;
    }

    private void visitRight(int i) {
        int k = i;
        for (int j = 0; j <= MOVE_USER_POINT; j++) {
            this.visitedList.set(k++, true);
        }
    }

    private void visitLeft(int i) {
        int k = i;
        for (int j = 0; j <= MOVE_USER_POINT; j++) {
            this.visitedList.set(k--, true);
        }
    }

    private void clearVisitedList() {
        this.visitedList = this.visitedList.stream()
                .map(v -> false)
                .collect(Collectors.toList());
    }


    public List<Boolean> getPoints() {
        return Collections.unmodifiableList(this.points);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LadderLine)) return false;
        LadderLine that = (LadderLine) o;
        return Objects.equals(points, that.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
