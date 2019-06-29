package com.ladder.exception;

import static com.ladder.model.Lines.MIN_NUMBER_OF_COLUMNS;

public class LadderColumnsException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE = "사다리 높이는 %s이상 입니다.";

    public LadderColumnsException() {
        super(String.format(ERROR_MESSAGE, MIN_NUMBER_OF_COLUMNS));
    }
}