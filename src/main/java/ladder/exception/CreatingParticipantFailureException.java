package ladder.exception;

public class CreatingParticipantFailureException extends RuntimeException {

    public CreatingParticipantFailureException() {
        this("참가자 생성에 실패했습니다.");
    }

    public CreatingParticipantFailureException(final String message) {
        super(message);
    }
}
