package ladder.domain.vo;

import java.util.Collections;
import java.util.List;

public class Rows {

    private final List<Row> rows;

    public Rows(List<Row> rows) {
        this.rows = rows;
    }

    public List<Row> Rows(){
        return Collections.unmodifiableList(rows);
    }

}
