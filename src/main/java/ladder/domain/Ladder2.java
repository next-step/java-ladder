package ladder.domain;

import lombok.Builder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder2 {
    private static final int FIRST_ROW = 0;

    private List<Row> rows;

    @Builder
    public Ladder2(int rowNumber, int columnNumber) {
       this.rows = initLadder(rowNumber, columnNumber);
    }

    private List<Row> initLadder(int rowNumber, int columnNumber) {
        List<Row> rows = new ArrayList<>();
        IntStream.range(0, rowNumber)
                .forEach(line -> rows.add(Row.valueOf(columnNumber)));
        return rows;
    }

    public void drawLine(int rowPosition, int columnPosition) {
        if (hasLine(rowPosition, columnPosition)) {
            return;
        }
        rows.get(rowPosition).drawLine(columnPosition);
    }

    public List<Row> getRows() {
        return rows;
    }

    public int getSizeOfColumn() {
        return rows.get(FIRST_ROW).getSize();
    }

    public boolean hasLine(int row, int column) {
        return rows.get(getUpperRow(row)).hasLine(column);
    }

    private int getUpperRow(int row) {
        return row <= 0 ? FIRST_ROW : row-1;
    }
}
