package ladder.exception;

public enum ErrorCode {
    INVALID_PARTICIPANTS_INPUT("I001", "Participants list should be Alphabet separated by comma"),
    INVALID_PARTICIPANTS_NAME("I002", "Participants cannot have name longer than 5 characters"),
    INVALID_LADDER_HEIGHT("L001", "Ladder height should be positive integer");

    private final String code;
    private final String message;

    ErrorCode(String code, String message){
        this.code = code;
        this.message = message;
    }

    @Override
    public String toString() {
        return String.format("ErrorCode{code=%s, message=%s}", code, message);
    }
}
