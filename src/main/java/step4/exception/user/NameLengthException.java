package step4.exception.user;

import step4.exception.CustomException;

public class NameLengthException extends CustomException {

    private static final String NAME_LENGTH_ERROR_MESSAGE = "사람의 이름은 최대 5글자까지만 입력가능하다.";

    public NameLengthException(String message) {
        super(message);
    }

    public NameLengthException() {
        this(NAME_LENGTH_ERROR_MESSAGE);
    }

}
