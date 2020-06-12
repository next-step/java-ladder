package camp.nextstep.edu.nextstep8.ladder.entity;

import java.util.Collections;
import java.util.List;

public class Ladder {
    private List<Row> rows;

    public Ladder(List<Row> rows) {
        this.rows = rows;
    }

    public List<Row> getRows() {
        return Collections.unmodifiableList(rows);
    }
}
