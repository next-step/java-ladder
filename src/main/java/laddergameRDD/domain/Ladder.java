package laddergameRDD.domain;

import laddergameRDD.engine.SelectStrategy;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Row> ladder = new ArrayList<>();

    public Ladder(int rowCount, int columnCount, SelectStrategy selectStrategy) {
        validateRowCount(rowCount);
        validateColumnCount(columnCount);
        for (int i = 0; i < rowCount; ++i) {
            ladder.add(new Row(columnCount, selectStrategy));
        }
    }

    private void validateColumnCount(int columnCount) {
        if (columnCount < 2) {
            throw new IllegalArgumentException("사람 수는 두 명 이상이어야 합니다.");
        }
    }

    private void validateRowCount(int rowCount) {
        if (rowCount < 1) {
            throw new IllegalArgumentException("최대 사다리의 높이는 1 이상이어야 합니다.");
        }
    }

    public int play(int sourceIndex) {
        int destinationIndex = sourceIndex;
        for (Row row: ladder) {
            destinationIndex = row.moveDown(destinationIndex);
        }
        return destinationIndex;
    }

    public List<Row> getLadder() {
        return ladder;
    }
}
