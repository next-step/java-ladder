package ladder.exception;

public enum ErrorCode {
    INVALID_PARTICIPANT_NAME_LENGTH("P001", "Participant Name Cannot Have More Than 5 characters"),
    INVALID_PARTICIPANT_INDEX("PL001", "Participant Index Not In Range"),
    INVALID_LADDER_HEIGHT("LA001", "Ladder Height Must Be Positive"),
    INVALID_POINT_INDEX("P001", "Point Index Cannot Be Negative"),
    INVALID_RESULT_INDEX("RC001", "Result Index Not In Range");

    private final String code;
    private final String message;

    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
