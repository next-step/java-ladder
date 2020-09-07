package ladder.view;

public enum OutputViewMessage {
    RESULT_START("실행결과\n");

    private final String message;

    OutputViewMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
