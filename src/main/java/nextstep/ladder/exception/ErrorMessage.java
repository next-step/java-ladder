package nextstep.ladder.exception;

public enum ErrorMessage {
    INVALID_LENGTH_OF_NAME("이름은 최대 {0}자까지 가능합니다.");

    String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
