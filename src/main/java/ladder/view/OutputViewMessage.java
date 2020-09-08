package ladder.view;

public enum OutputViewMessage {
    RESULT_LADDER("\n사다리결과\n"),
    RESULT_START("\n실행결과");

    private final String message;

    OutputViewMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
