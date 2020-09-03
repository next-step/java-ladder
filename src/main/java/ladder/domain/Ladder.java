package ladder.domain;

import lombok.Builder;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {
    private static final int FIRST_ROW = 0;

    private final List<Row> rows;

    @Builder
    public Ladder(int rowCount, int columnCount) {
       this.rows = initLadder(rowCount, columnCount);
    }

    private List<Row> initLadder(int rowCount, int columnCount) {
        return Stream.generate(() -> Row.valueOf(columnCount))
                .limit(rowCount-1)
                .collect(Collectors.toList());
    }

    public void drawLine(int rowPosition, int columnPosition) {
        if (hasLine(rowPosition, columnPosition)) {
            return;
        }
        rows.get(rowPosition).drawLine(columnPosition);
    }

    public List<Row> getRows() {
        return Collections.unmodifiableList(rows);
    }

    public int getCountOfColumn() {
        return rows.get(FIRST_ROW).getSize();
    }

    public boolean hasLine(int row, int column) {
        return rows.get(getUpperRow(row)).hasLine(column);
    }

    private int getUpperRow(int row) {
        return row <= 0 ? FIRST_ROW : row-1;
    }
}
