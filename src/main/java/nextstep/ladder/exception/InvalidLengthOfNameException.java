package nextstep.ladder.exception;

import java.text.MessageFormat;

public class InvalidLengthOfNameException extends RuntimeException {
    public InvalidLengthOfNameException(ErrorMessage message, int value) {
        super(MessageFormat.format(message.getMessage(), value));
    }
}
