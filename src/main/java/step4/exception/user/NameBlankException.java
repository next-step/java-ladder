package step4.exception.user;

import step4.exception.CustomException;

public class NameBlankException extends CustomException {

    private static final String NAME_BLANK_ERROR_MESSAGE = "이름은 필수로 제공되어야 한다.";

    public NameBlankException(String message) {
        super(message);
    }

    public NameBlankException() {
        this(NAME_BLANK_ERROR_MESSAGE);
    }

}
