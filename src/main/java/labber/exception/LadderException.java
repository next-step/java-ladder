package labber.exception;

public class LadderException extends RuntimeException {
    private static final String HEIGHT_EXCEPTION = "사다리 최소 높이 부족";

    public LadderException() {
        super(HEIGHT_EXCEPTION);
    }
}
