package step4.exception.user;

import step4.exception.CustomException;

public class UsersCountException extends CustomException {

    private static final String USER_COUNT_ERROR_MESSAGE = "사람의 수는 2명이상이 들어와야 한다.";

    public UsersCountException(String message) {
        super(message);
    }

    public UsersCountException() {
        this(USER_COUNT_ERROR_MESSAGE);
    }
}
