package com.jaeyeonling.ladder.exception;

import com.jaeyeonling.ladder.domain.Positive;

public class ShorterThanMinPositiveException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE = "정수 값은 %d 미만일 수 없습니다. (입력 값: %d)";

    public ShorterThanMinPositiveException(final int input) {
        super(String.format(ERROR_MESSAGE, Positive.MIN, input));
    }
}
