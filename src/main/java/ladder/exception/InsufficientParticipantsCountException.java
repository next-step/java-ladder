package ladder.exception;

public class InsufficientParticipantsCountException extends RuntimeException{

    private static final String MESSAGE = "최소 2명 이상의 참여자가 있어야합니다.";

    public InsufficientParticipantsCountException() {
        super(MESSAGE);
    }
}
