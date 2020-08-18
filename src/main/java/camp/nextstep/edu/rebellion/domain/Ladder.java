package camp.nextstep.edu.rebellion.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {
    private final int INIT_INDEX = 0;
    private final int sizeOfRows;
    private final int sizeOfPoints;
    private final List<Row> rows;

    public Ladder(int sizeOfRows, int sizeOfPoints) {
        this.sizeOfRows = sizeOfRows;
        this.sizeOfPoints = sizeOfPoints;
        this.rows = generateRows(sizeOfRows, sizeOfPoints);
    }

    public int getSizeOfRows() {
        return sizeOfRows;
    }

    public int getSizeOfPoints() {
        return sizeOfPoints;
    }

    public void drawLine(int positionOfRow, int positionOfCol) {
        Row cur = pick(positionOfRow);
        Row prev = pick(positionOfRow - 1);

        if (prev.hasHorizonLine(positionOfCol)) {
            return;
        }

        cur.mark(positionOfCol);
    }

    public List<Row> getRows() {
        return Collections.unmodifiableList(rows);
    }

    private Row pick(int ordinal) {
        return this.rows
                .get(Math.max(ordinal, INIT_INDEX));
    }

    private List<Row> generateRows(int sizeOfRows, int sizeOfPoints) {
        List<Row> rows = new ArrayList<>();
        IntStream
                .range(INIT_INDEX, sizeOfRows)
                .forEach(r -> rows.add(new Row(sizeOfPoints)));
        return rows;
    }
}
