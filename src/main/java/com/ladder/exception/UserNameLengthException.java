package com.ladder.exception;

import static com.ladder.model.UserName.LENGTH_OF_USER_NAME;

public class UserNameLengthException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE = "이름을 " + LENGTH_OF_USER_NAME + "글자이하로 작성해주세요.(입력값 : %s)";

    public UserNameLengthException(String name) {
        super(String.format(ERROR_MESSAGE, name));
    }
}
