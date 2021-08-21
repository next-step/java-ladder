package ladder.exception;

public class NotMatchInParticipantException extends IllegalArgumentException {
    private static final String MESSAGE = "참가자 명단에 존재 하지 않습니다. : ";

    public NotMatchInParticipantException(String person) {
        super(MESSAGE + person);
    }
}