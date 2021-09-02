package step4.ladderGame.domain.palyer;

import step4.ladderGame.domain.exception.IndexLowException;
import step4.ladderGame.domain.exception.NameLengthException;
import step4.ladderGame.domain.exception.NameNullOrEmptyException;

public final class Player {

    private static final int MIN_LENGTH_BY_NAME = 1;
    private static final int MAX_VALUE_BY_NAME = 5;
    private static final int MIN_LENGTH_BY_INDEX = 0;

    private final String name;
    private final int index;

    public Player(final String name, final int index) {
        validate(name, index);
        this.name = name;
        this.index = index;
    }

    public void validate(final String name, final int index) {
        if (name == null || name.isEmpty()) {
            throw new NameNullOrEmptyException();
        }
        if (name.length() < MIN_LENGTH_BY_NAME || name.length() > MAX_VALUE_BY_NAME) {
            throw new NameLengthException();
        }
        if (index < MIN_LENGTH_BY_INDEX) {
            throw new IndexLowException();
        }
    }

    public String getName() {
        return name;
    }

    public int getIndex() {
        return index;
    }

}
