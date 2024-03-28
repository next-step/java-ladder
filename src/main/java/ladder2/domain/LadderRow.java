package ladder2.domain;

import java.util.List;

public class LadderRow {

    private final List<LadderColumn> columns;

    public LadderRow(List<LadderColumn> columns) {
        validateColumns(columns);
        this.columns = columns;
    }
}
