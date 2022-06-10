package ladder.exception;

public class ParticipantNotFoundException extends RuntimeException {
    private static final String NOT_FOUND_PARTICIPANT_ERROR_MESSAGE = "해당 참가자를 찾을 수 없습니다.";

    public ParticipantNotFoundException() {
        super(NOT_FOUND_PARTICIPANT_ERROR_MESSAGE);
    }
}
