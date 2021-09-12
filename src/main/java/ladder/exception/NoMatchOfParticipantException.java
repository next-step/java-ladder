package ladder.exception;

public class NoMatchOfParticipantException extends RuntimeException {
    private static final String MESSAGE = "찾고자하는 참가자가 없습니다.";

    public NoMatchOfParticipantException(String name) {
        super(String.format(MESSAGE, name));
    }
}
