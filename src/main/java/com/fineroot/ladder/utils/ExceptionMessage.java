package com.fineroot.ladder.utils;

public enum ExceptionMessage {
    UTILITY_CLASS("Utility class는 생성을 허용하지 않습니다."),
    USER_NAME_EMPTY("참여자의 이름은 필수 입력입니다."),
    USER_NAME_LENGTH_OVER("참여자의 이름은 총 5글자를 넘길 수 없습니다."),
    USER_NAME_DUPLICATED("참여자의 이름은 중복될 수 없습니다."),
    STEP_ROW_LINE_BOTH_TRUE("스텝은 나란히 놓일 수 없습니다."),
    BAR_FACTORY_NEXT_AFTER_LAST("last() 호출 이후 next()사용은 불가능합니다."),
    POSITION_NEGATIVE("Position은 음수를 가질 수 없습니다.");

    private final String message;
    ExceptionMessage(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
