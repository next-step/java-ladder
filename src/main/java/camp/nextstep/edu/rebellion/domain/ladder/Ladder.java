package camp.nextstep.edu.rebellion.domain.ladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {
    private static final int INIT_INDEX = 0;

    private final int sizeOfPoints;
    private final List<Row> rows;

    public Ladder(int sizeOfRows, int sizeOfPoints) {
        this.sizeOfPoints = sizeOfPoints;
        this.rows = generateRows(sizeOfRows, sizeOfPoints);
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

    public int getFinalPosition(int startingPoint) {
        int finalPosition = startingPoint;
        for (Row r : rows) {
            finalPosition = r.getNextPathOrdinal(finalPosition);
        }
        return finalPosition;
    }

    private Row pick(int ordinal) {
        return this.rows
                .get(getPositiveOrdinal(ordinal));
    }

    private int getPositiveOrdinal(int ordinal) {
        return ordinal < 0 ? INIT_INDEX : ordinal;
    }

    private List<Row> generateRows(int sizeOfRows, int sizeOfPoints) {
        List<Row> rows = new ArrayList<>();
        IntStream
                .range(INIT_INDEX, sizeOfRows)
                .forEach(r -> rows.add(new Row(sizeOfPoints)));
        return rows;
    }
}
