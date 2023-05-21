package ladder.domain.exception;

public enum LadderException {
    PARTICIPANT_NAME_IS_NULL("참가자의 이름을 입력해야 합니다."),
    PARTICIPANT_NAME_OVER_LIMIT("이름은 5글자까지만 입력 가능합니다."),
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
