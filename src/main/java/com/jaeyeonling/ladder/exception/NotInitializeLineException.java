package com.jaeyeonling.ladder.exception;

public class NotInitializeLineException extends IllegalStateException {

    private static final String ERROR_MESSAGE = "사다리가 초기화되지 않았습니다.";

    public NotInitializeLineException() {
        super(ERROR_MESSAGE);
    }
}
