package ladder.error;

public enum ErrorMessage {

    ERR_OUT_OF_LENGTH("최대 길이를 벗어났습니다."),
    ERR_INVALID_POINT("라인이 겹칩니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String print() {
        return this.message;
    }
}
