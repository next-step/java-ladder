package com.jaeyeonling.ladder2.exception;

import com.jaeyeonling.ladder2.domain.Index;

public class ShorterThanMinPositionException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE = "위치 값은 %d 미만일 수 없습니다. (입력 값: %d)";

    public ShorterThanMinPositionException(final int input) {
        super(String.format(ERROR_MESSAGE, Index.MIN, input));
    }
}
