package ladder.exception;

public class NotFoundUserNameException extends RuntimeException {
    private static final String NOT_FOUNT_USER_NAME = "유저 이름을 찾을 수 없습니다.";

    public NotFoundUserNameException() {
        super(NOT_FOUNT_USER_NAME);
    }
}
