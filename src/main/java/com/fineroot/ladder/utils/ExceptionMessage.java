package com.fineroot.ladder.utils;

public enum ExceptionMessage {
    UTILITY_CLASS("Utility class는 생성을 허용하지 않습니다."),
    USER_NAME_EMPTY("참여자의 이름은 필수 입력입니다."),
    USER_NAME_LENGTH_OVER("참여자의 이름은 총 5글자를 넘길 수 없습니다."),
    USER_NAME_DUPLICATED("참여자의 이름은 중복될 수 없습니다."),
    STEP_ROW_LINE_BOTH_TRUE("스텝은 나란히 놓일 수 없습니다."),
    USERS_CALL_LONGEST_LENGTH("존재할 수 없는 값입니다.");

    private final String message;
    ExceptionMessage(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
