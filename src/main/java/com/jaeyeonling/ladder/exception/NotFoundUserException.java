package com.jaeyeonling.ladder.exception;

public class NotFoundUserException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE = "해당 이름을 가진 유저를 찾을 수 없습니다. (입력 유저이름: %s)";

    public NotFoundUserException(final String input) {
        super(String.format(ERROR_MESSAGE, input));
    }
}
