package ladder.exception;

public class NameLengthOutOfRangeException extends IllegalArgumentException {

    private static final String MESSAGE = ErrorMessage.RANGE_OF_PLAYER_NAME + ": %s";

    public NameLengthOutOfRangeException(final String value) {
        super(String.format(MESSAGE, value));
    }
}
