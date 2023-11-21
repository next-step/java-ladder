package ladder.domain;

import ladder.exception.InvalidLadderException;
import ladder.factory.ColFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {

    private static final int MIN_COUNT_OF_COL = 2;

    private final List<Row> rows = new ArrayList<>();

    public Ladder(int row, int col, ColFactory factory) {
        validate(col);

        for (int i = 0; i < row; i++) {
            this.rows.add(new Row(col - 1, factory));
        }
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
