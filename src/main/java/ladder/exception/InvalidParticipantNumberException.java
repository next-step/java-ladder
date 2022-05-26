package ladder.exception;

public class InvalidParticipantNumberException extends RuntimeException {

    private static final String INVALID_PARTICIPANT_NUMBER_MESSAGE = "참가자를 두 명 이상 입력해주세요.";

    public InvalidParticipantNumberException() {
        super(INVALID_PARTICIPANT_NUMBER_MESSAGE);
    }
}
