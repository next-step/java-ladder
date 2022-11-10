package laddergame;

public enum ErrorCode {
    NULL_OR_EMPTY_INPUT("공백이거나 null 일 수 없다."),
    NAME_OVER_MAXMUM_LENGTH("참가자 이름은 최대 5글자 입니다."),
    INSUFFICAINT_PLAYER_NAMES("참가자 이름을 2개 이상 입력하세요.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

