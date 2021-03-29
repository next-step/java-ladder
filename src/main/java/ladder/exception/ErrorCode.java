package ladder.exception;

public enum ErrorCode {
    INVALID_PARTICIPANTS_INPUT("I001", "Participants list should be Alphabet separated by comma"),
    INVALID_PARTICIPANTS_NAME("I002", "Participants cannot have name longer than 5 characters"),
    INVALID_LADDER_HEIGHT("LA001", "Ladder height should be positive integer"),
    INVALID_LINK_INDEX("LI001", "Link index cannot be negative"),
    INVALID_ARGUMENT_FOR_MATCHING("LI002", "Index for matching does not exist"),
    INVALID_RESULT_SIZE("R001", "Result size is not equal to the input size"),
    INVALID_RESULT_INDEX("R002", "Result index not in range"),
    INVALID_PARTICIPANT_INDEX("P001", "Participant index not in range");

    private final String code;
    private final String message;

    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String toString() {
        return String.format("ErrorCode{code=%s, message=%s}", code, message);
    }
}
