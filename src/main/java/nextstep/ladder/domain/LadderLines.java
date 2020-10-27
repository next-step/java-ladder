package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderLines {
    public static final int MIN_HEIGHT = 1;

    private final List<LadderLine> lines;

    private LadderLines(List<LadderLine> lines) {
        this.lines = lines;
    }

    public static LadderLines of(int sizeOfPersons, int height) {
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException("사다리의 높이는 1 이상이여야 합니다.");
        }
        List<LadderLine> lines = IntStream.range(0, height)
                .mapToObj(i -> LadderLine.init(sizeOfPersons))
                .collect(Collectors.toList());

        return new LadderLines(lines);
    }

    public List<LadderLine> getLines() {
        return lines;
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

    private boolean isLastRow(int row) {
        int height = lines.size();
        return row == height;
    }

    private int moveCol(int row, int col) {
        return lines.get(row).move(col);
    }
}
