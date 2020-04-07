package ladder.exception;

public class PlayerException extends RuntimeException {

    private static final String MSG = "참가자 생성 실패 : %s";

    public PlayerException(String message) {
        super(String.format(MSG, message));
    }
}
