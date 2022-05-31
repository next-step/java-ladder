package ladder.exception;

import ladder.domain.Index;

public class InvalidBoundIndexException extends IllegalArgumentException {

    private static final String MESSAGE = "%d ~ %d 사이의 값만 가능합니다.";

    public InvalidBoundIndexException(int max) {
        super(String.format(MESSAGE, Index.MIN_VALUE, max));
    }
}
