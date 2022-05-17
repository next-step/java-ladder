package nextstep.ladder.exception;

public enum LadderExceptionCode {
    INVALID_NAME_FORMAT("이름은 null이거나 빈 값은 안됩니다."),
    INVAILD_NAME_LENGTH("이름은 0~5글자 사이어야 합니다."),
    INVAILD_LADDER_HEIGHT("사다리 높이는 1이상 이어야 합니다."),
    FAIL_LADDER_INITIALIZATION("사다리는 라인이 1이상 이어야 합니다.");
    
    private final String message;

    LadderExceptionCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
