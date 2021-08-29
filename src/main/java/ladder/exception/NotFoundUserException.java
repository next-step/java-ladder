package ladder.exception;

public class NotFoundUserException extends RuntimeException {
    private static final String NOT_FOUND_USER = "해당하는 유저를 찾을수 없습니다.";

    public NotFoundUserException() {
        super(NOT_FOUND_USER);
    }
}
