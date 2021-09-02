package step3.ladderGame.domain.award;

import step3.ladderGame.domain.exception.IndexLowException;
import step3.ladderGame.domain.exception.NameNullOrEmptyException;

public final class Award {

    private static final int MIN_LENGTH_BY_INDEX = 0;

    private final String name;
    private final int index;

    public Award(final String name, final int index) {
        validate(name, index);
        this.name = name;
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

    public String getName() {
        return this.name;
    }

    public int getIndex() {
        return this.index;
    }

}
