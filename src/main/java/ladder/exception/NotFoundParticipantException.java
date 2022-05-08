package ladder.exception;

public class NotFoundParticipantException extends RuntimeException {
    private static final String MESSAGE = "입력한 이름은 없는 존재하지 않는 참가자입니다.";

    public NotFoundParticipantException() {
        super(MESSAGE);
    }
}
