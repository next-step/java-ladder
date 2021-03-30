package ladder.exception;

public enum ErrorCode {
    INVALID_PARTICIPANT_NAME_LENGTH("P001", "Participant Name Cannot Have More Than 5 characters"),
    INVALID_PARTICIPANT_INDEX("PL001", "Participant List Not In Range"),
    INVALID_LADDER_HEIGHT("LA001", "Ladder Height Cannot Be Negative");

    private String code;
    private String message;

    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
