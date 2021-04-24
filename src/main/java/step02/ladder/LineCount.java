package step02.ladder;

import step02.exception.ZeroHeightException;
import step02.utils.Validation;

public class LineCount {
    private final int count;

    public LineCount(int count) throws ZeroHeightException {
        Validation.checkZeroLine(count);
        this.count = count;
    }

    public int getCount() {
        return count;
    }
}
