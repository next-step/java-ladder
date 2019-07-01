package com.ladder.exception;

import static com.ladder.model.Players.MIN_NUMBER_OF_PLAYERS;

public class NegativeNumberException extends IllegalArgumentException {

    private static final String DEFAULT_ERROR_MESSAGE = "0 또는 양수여야 합니다.";
    private static final String ERROR_MESSAGE = "%s은 0 또는 양수여야 합니다.";

    public NegativeNumberException() {
        super(String.format(DEFAULT_ERROR_MESSAGE));
    }

    public NegativeNumberException(String message) {
        super(String.format(ERROR_MESSAGE, message));
    }
}
