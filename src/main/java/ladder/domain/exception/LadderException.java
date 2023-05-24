package ladder.domain.exception;

public enum LadderException {


    HEIGHT_UNDER_ZERO("높이는 0보다 큰 수를 입력해야 합니다.")
    ;

    private final String message;

    LadderException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
