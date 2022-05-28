package ladder.exception;

public class NotFoundElementException extends IllegalArgumentException {

    private static final String MESSAGE = "%s를 찾을 수 없습니다.";

    public NotFoundElementException(String name) {
        super(String.format(MESSAGE, name));
    }
}
