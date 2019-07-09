package com.jaeyeonling.ladder2.exception;

import com.jaeyeonling.ladder2.domain.user.Username;

public class LongerThanMaxLengthUsernameException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE = "유저의 이름의 길이는 %d를 넘을 수 없습니다. (입력 값: %s)";

    public LongerThanMaxLengthUsernameException(final String input) {
        super(String.format(ERROR_MESSAGE, Username.MAX_LENGTH, input));
    }
}
