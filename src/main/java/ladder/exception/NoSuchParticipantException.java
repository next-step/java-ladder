package ladder.exception;

public final class NoSuchParticipantException extends RuntimeException {

    private final String message = "사다리에 참가한 참가자의 이름이 아닙니다.";

    @Override
    public final String getMessage() {
        return message;
    }
}