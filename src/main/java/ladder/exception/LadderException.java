package ladder.exception;

public class LadderException extends RuntimeException {
    private ExceptionType type;

    public LadderException(ExceptionType type) {
        super(type.getErrorMessage());
        this.type = type;
    }
}
