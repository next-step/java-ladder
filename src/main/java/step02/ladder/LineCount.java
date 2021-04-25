package step02.ladder;

import step02.exception.ZeroHeightException;

public class LineCount {
    private final static String ERROR_ZERO_LINE = "사다리는 높이 0이상으로 입력해주세요.";
    private final static int ZERO = 0;

    private final int count;

    public LineCount(int count) throws ZeroHeightException {
        checkZeroLine(count);
        this.count = count;
    }

    private void checkZeroLine(int height) throws ZeroHeightException {
        if (height <= ZERO) {
            throw new ZeroHeightException(ERROR_ZERO_LINE);
        }
    }

    public int getCount() {
        return count;
    }
}
