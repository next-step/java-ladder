package ladder.exception;

import ladder.domain.Height;

public class InvalidHeightException extends IllegalArgumentException {

    private static final String MESSAGE = "사다리의 높이는 최소 %d 이상이여야 합니다.";

    public InvalidHeightException() {
        super(String.format(MESSAGE, Height.MIN_VALUE));
    }
}
