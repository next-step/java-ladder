package nextstep.step4.responsibility.domain;

import java.util.List;

public class Row {
    private final List<IndexHorizontalMover> row;

    public Row(final List<IndexHorizontalMover> row) {
        this.row = row;
    }

    public IndexHorizontalMover get(final int index) {
        return this.row.get(index);
    }

    public int size() {
        return this.row.size();
    }
}
