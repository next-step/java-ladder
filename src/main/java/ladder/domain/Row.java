package ladder.domain;

import ladder.exception.LineDuplicateException;

import java.util.List;

public class Row {

    private final List<Boolean> cols;

    public Row(List<Boolean> cols) {
        this.cols = cols;
        validate();
    }

    private void validate() {
        for (int i = 0; i < cols.size() - 1; i++) {
            validateDuplicate(i);
        }
    }

    private void validateDuplicate(int index) {
        Boolean col1 = cols.get(index);
        Boolean col2 = cols.get(index + 1);

        if (col1 && col2) {
            throw new LineDuplicateException();
        }
    }

    public Boolean isBoundary(int position) {
        return position < 0 || position == cols.size();
    }

    public Boolean movable(int position) {
        return cols.get(position);
    }

    public List<Boolean> cols() {
        return this.cols;
    }

}
