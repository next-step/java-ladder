package ladder.domain;

import ladder.exception.InvalidLadderException;
import ladder.factory.RowFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {

    private static final int MIN_COUNT_OF_COL = 2;

    private final List<Row> rows = new ArrayList<>();

    public Ladder(int row, int col, RowFactory factory) {
        validate(col);
        this.rows.addAll(factory.rows(row, col - 1));
    }

    private void validate(int col) {
        if (col < MIN_COUNT_OF_COL) {
            throw new InvalidLadderException();
        }
    }

    public List<Row> rows() {
        return Collections.unmodifiableList(this.rows);
    }

}
