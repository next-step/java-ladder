package com.jaeyeonling.ladder2.exception;

public class NotEqualsUserSizeAndRewordSizeException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE = "유저의 숫자와 결과의 숫자는 일치해야 합니다. (유저: %d명 / 결과: %d개)";

    public NotEqualsUserSizeAndRewordSizeException(final int sizeOfUser,
                                                   final int sizeOfRewords) {
        super(String.format(ERROR_MESSAGE, sizeOfUser, sizeOfRewords));
    }
}
