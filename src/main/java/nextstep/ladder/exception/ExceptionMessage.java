package nextstep.ladder.exception;

public enum ExceptionMessage {

    NAME_OUT_OF_RANGE("이름은 최대 5글자 까지 입니다."),
    NAME_IS_NONE("이름은 비어 있을 수 없습니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String message() {
        return this.message;
    }
}
