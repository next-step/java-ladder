package com.jaeyeonling.ladder.exception;

public class EmptyLadderRewordException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE = "당첨 결과는 빈 값일 수 없습니다.";

    public EmptyLadderRewordException() {
        super(ERROR_MESSAGE);
    }
}
