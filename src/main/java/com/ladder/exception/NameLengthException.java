package com.ladder.exception;

import static com.ladder.model.Player.LENGTH_OF_USER_NAME;

public class NameLengthException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE = "이름을 %s글자 이하로 작성해주세요.(입력값 : %s)";

    public NameLengthException(String name) {
        super(String.format(ERROR_MESSAGE, LENGTH_OF_USER_NAME, name));
    }
}
