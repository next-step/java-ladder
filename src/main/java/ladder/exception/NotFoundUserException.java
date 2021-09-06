package ladder.exception;

public class NotFoundUserException extends RuntimeException {
    private static final String NOT_FOUND_USER = "해당하는 유저(%s)를 찾을수 없습니다. ";

    public NotFoundUserException(String user) {
        super(String.format(NOT_FOUND_USER, user));
    }
}
