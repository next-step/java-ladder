package ladder.domain;

import ladder.exception.InvalidColSizeException;
import ladder.exception.LineDuplicateException;

import java.util.List;

public class Row {

    private static final int MIN_COUNT_OF_COLS = 2;

    private final List<Boolean> cols;

    public Row(List<Boolean> cols) {
        this.cols = cols;
        validate();
    }

    private void validate() {
        validateSize();
        validateDuplicate();
    }

    private void validateSize() {
        if(this.cols.size() < MIN_COUNT_OF_COLS) {
            throw new InvalidColSizeException();
        }
    }

    private void validateDuplicate() {
        for (int i = 0; i < this.cols.size() - 1; i++) {
            validateDuplicate(i);
        }
    }

    private void validateDuplicate(int index) {
        Boolean col1 = this.find(index);
        Boolean col2 = this.find(index + 1);

        if (col1 && col2) {
            throw new LineDuplicateException();
        }
    }

    public Boolean movable(int position) {
        return this.find(position);
    }

    private Boolean find(int index) {
        return this.cols.get(index);
    }

    public List<Boolean> cols() {
        return this.cols;
    }

    public int size() {
        return this.cols.size();
    }

}
