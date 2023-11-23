package ladder.domain;

import ladder.factory.RowStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {

    private final List<Row> rows = new ArrayList<>();

    public Ladder(RowStrategy rowStrategy) {
        this.rows.addAll(rowStrategy.rows());
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
