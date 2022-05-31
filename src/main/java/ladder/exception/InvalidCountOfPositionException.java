package ladder.exception;

import ladder.domain.Positions;

public class InvalidCountOfPositionException extends IllegalArgumentException {
    private static final String MESSAGE = "참가자의 수는 %d 이상이여야 합니다.";

    public InvalidCountOfPositionException() {
        super(String.format(MESSAGE, Positions.MIN_COUNT_OF_POSITION));
    }

    public InvalidCountOfPositionException(String message) {
        super(message);
    }
}
