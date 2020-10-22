package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lines {
    public static final int MIN_HEIGHT = 1;

    private final List<Line> lines;

    private Lines(List<Line> lines) {
        this.lines = lines;
    }

    public List<Line> getLines() {
        return lines;
    }

    public static Lines random(int countOfPersons, int height) {
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException("사다리의 높이는 1 이상이여야 합니다.");
        }
        List<Line> lines = IntStream.range(0, height)
                .mapToObj(i -> Line.random(countOfPersons))
                .collect(Collectors.toList());

        return new Lines(lines);
    }

    public boolean isLastRow(int row) {
        int height = lines.size();
        return row == height;
    }

    public int moveCol(int row, int col) {
        if (isMovableLeft(row, col)) {
            return col - 1;
        }
        if (isMovableRight(row, col)) {
            return col + 1;
        }

        return col;
    }

    private boolean isMovableLeft(int row, int col) {
        return lines.get(row).isMovableToLeft(col);
    }

    private boolean isMovableRight(int row, int col) {
        return lines.get(row).isMovableToRight(col);
    }

    public int down(int startIdx) {
        int row = 0;
        int col = startIdx;
        while (!isLastRow(row)) {
            col = moveCol(row, col);
            row++;
        }
        return col;
    }
}
