package ladder.domain;

import ladder.exception.LineDuplicateException;
import ladder.factory.ColFactory;

import java.util.List;

public class Row {

    private final List<Boolean> cols;

    public Row(int col, ColFactory factory) {
        this.cols = factory.cols(col);
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

    public List<Boolean> cols() {
        return this.cols;
    }

}
