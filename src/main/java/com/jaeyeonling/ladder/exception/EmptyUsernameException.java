package com.jaeyeonling.ladder.exception;

public class EmptyUsernameException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE = "유저의 이름은 빈 값일 수 없습니다.";

    public EmptyUsernameException() {
        super(ERROR_MESSAGE);
    }
}
