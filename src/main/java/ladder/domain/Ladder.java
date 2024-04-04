package ladder.domain;

import ladder.domain.vo.Column;
import ladder.domain.vo.Columns;
import ladder.domain.vo.Rows;

import java.util.List;
import java.util.Objects;

public class Ladder {

    private final Columns columns;
    private final Rows rows;

    public Ladder(Columns columns,
                  Rows rows) {
        this.columns = columns;
        this.rows = rows;
    }
}
