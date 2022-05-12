package nextstep.ladder.exception;

public enum LadderExceptionCode {
    INVAILD_NAME_LENGTH("이름은 0~5글자 사이어야 합니다."), INVAILD_LADDER_HEIGHT("사디리 높이는 1이상이어야 합니다.");
    
    private final String message;

    LadderExceptionCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
