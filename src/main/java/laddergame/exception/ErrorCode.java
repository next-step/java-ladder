package laddergame.exception;

public enum ErrorCode {
    NULL_OR_EMPTY_INPUT("공백이거나 null 일 수 없다."),
    NAME_OVER_MAXMUM_LENGTH("참가자 이름은 최대 5글자 입니다."),
    HEIGHT_UNDER_MINIMUM("사다리 높이는 1보다 작을 수 없습니다."),
    WIDTH_UNDER_MINIMUM("사다리 너비는 1보다 작을 수 없습니다.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

