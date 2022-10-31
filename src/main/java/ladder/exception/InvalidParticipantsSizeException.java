package ladder.exception;

public class InvalidParticipantsSizeException extends RuntimeException {

    public InvalidParticipantsSizeException() {
        super("참가자는 최소 1명 이상이여야 합니다.");
    }
}
