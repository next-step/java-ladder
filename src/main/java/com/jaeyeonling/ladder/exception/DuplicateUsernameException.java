package com.jaeyeonling.ladder.exception;

public class DuplicateUsernameException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE = "유저 이름은 중복될 수 없습니다.";

    public DuplicateUsernameException() {
        super(ERROR_MESSAGE);
    }
}
