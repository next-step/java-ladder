package step3.ladderGame.domain.result;

import step2.ladderGame.domain.exception.NameNullOrEmptyException;
import step3.ladderGame.domain.exception.IndexLowException;

public final class Result {

    private static final int MIN_LENGTH_BY_RESULT = 1;
    private static final int MAX_VALUE_BY_RESULT = 5;
    private static final int MIN_LENGTH_BY_INDEX = 0;

    private final String result;
    private final int index;

    public Result(final String result, final int index) {
        validate(result, index);
        this.result = result;
        this.index = index;
    }

    public void validate(final String result, final int index) {
        if (result == null || result.isEmpty()) {
            throw new NameNullOrEmptyException();
        }
        if (index < MIN_LENGTH_BY_INDEX) {
            throw new IndexLowException();
        }
    }

    public String getResult() {
        return this.result;
    }

    public int getIndex() {
        return this.index;
    }

}
