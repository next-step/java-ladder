package ladder.exception;

import ladder.domain.Position;

public class InvalidBoundPositionException extends IllegalArgumentException {

    private static final String MESSAGE = "%d ~ %d 사이의 값만 가능합니다.";

    public InvalidBoundPositionException(int max) {
        super(String.format(MESSAGE, Position.MIN_VALUE, max));
    }
}
