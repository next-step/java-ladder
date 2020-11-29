package exception;

public class NotFoundNameException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "이름을 찾을 수 없습니다.";

    public NotFoundNameException() {
        super(ERROR_MESSAGE);
    }
}
