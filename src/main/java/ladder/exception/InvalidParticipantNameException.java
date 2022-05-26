package ladder.exception;

public class InvalidParticipantNameException extends RuntimeException {

    private static final String INVALID_PARTICIPANT_NAME_ERROR_MESSAGE = "사용자의 이름을 1글자 이상, 5글자 이하로 입력해주세요.";

    public InvalidParticipantNameException() {
        super(INVALID_PARTICIPANT_NAME_ERROR_MESSAGE);
    }
}
