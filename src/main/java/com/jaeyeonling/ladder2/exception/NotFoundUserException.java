package com.jaeyeonling.ladder2.exception;

import com.jaeyeonling.ladder2.domain.user.Username;

public class NotFoundUserException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE = "해당 유저를 찾을 수 없습니다. (입력 값: %s)";

    public NotFoundUserException(final Username username) {
        super(String.format(ERROR_MESSAGE, username.visualize()));
    }
}
