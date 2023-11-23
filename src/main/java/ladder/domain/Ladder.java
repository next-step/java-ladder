package ladder.domain;

import ladder.exception.InvalidLadderException;
import ladder.factory.RowStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {

    private static final int MIN_COUNT_OF_COL = 2;

    private final List<Row> rows = new ArrayList<>();

    public Ladder(int row, int col, RowStrategy rowStrategy) {
        validate(col);
        this.rows.addAll(rowStrategy.rows(row, col - 1));
    }

    private void validate(int col) {
        if (col < MIN_COUNT_OF_COL) {
            throw new InvalidLadderException();
        }
    }

    public List<Row> rows() {
        return Collections.unmodifiableList(this.rows);
    }

    public Position positionFrom(Position startPosition) {
        Position position = startPosition;
        for (Row row : this.rows) {
            position = position.moved(row);
        }
        return position;
    }

}
