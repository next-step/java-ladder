package com.jaeyeonling.ladder.exception;

public class NotEqualsUserSizeAndResultSizeException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE = "유저의 숫자와 결과의 숫자는 일치해야 합니다. (유저: %d명 / 결과: %d개)";

    public NotEqualsUserSizeAndResultSizeException(final int sizeOfUser,
                                                   final int sizeOfResults) {
        super(String.format(ERROR_MESSAGE, sizeOfUser, sizeOfResults));
    }
}
