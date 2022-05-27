package ladder.exception;

import ladder.domain.Elements;

public class InvalidCountOfElementException extends IllegalArgumentException {
    private static final String MESSAGE = "참가자의 수는 %d 이상이여야 합니다.";

    public InvalidCountOfElementException() {
        super(String.format(MESSAGE, Elements.MIN_COUNT_OF_PERSON));
    }

    public InvalidCountOfElementException(String message) {
        super(message);
    }
}
