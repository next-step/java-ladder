package ladder.exception;

import ladder.domain.Line;

public class InvalidCountOfPersonException extends IllegalArgumentException {
    private static final String MESSAGE = "참가자의 수는 %d 이상이여야 합니다.";

    public InvalidCountOfPersonException() {
        super(String.format(MESSAGE, Line.MIN_COUNT_OF_PERSON));
    }
}
