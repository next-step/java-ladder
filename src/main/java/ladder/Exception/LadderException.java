package ladder.Exception;

public class LadderException extends RuntimeException {
    private ExceptionType type;

    public LadderException(ExceptionType type) {
        super(type.getErrorMessage());
        this.type = type;
    }
}
