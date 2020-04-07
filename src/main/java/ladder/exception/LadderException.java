package ladder.exception;

public class LadderException extends RuntimeException {

    private static final String MSG = "사다리 생성 실패 : %s";

    public LadderException(String message) {
        super(String.format(MSG, message));
    }
}
