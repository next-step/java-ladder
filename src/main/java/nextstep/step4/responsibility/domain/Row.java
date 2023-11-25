package nextstep.step4.responsibility.domain;

public class Row {
    private final IndexHorizontalMover[] row;

    public Row(final IndexHorizontalMover[] row) {
        this.row = row;
    }

    public IndexHorizontalMover get(final int index) {
        return this.row[index];
    }

    public int size() {
        return this.row.length;
    }
}
