package nextstep.ladder.exception;

public class NullArgumentException extends IllegalArgumentException {
    private static final String MESSAGE_FORMAT = "%s can't be null";

    @SuppressWarnings("rawtypes")
    public NullArgumentException(Class clazz) {
        super(String.format(MESSAGE_FORMAT, clazz.getSimpleName()));
    }

    public NullArgumentException(String target) {
        super(String.format(MESSAGE_FORMAT, target));
    }
}
