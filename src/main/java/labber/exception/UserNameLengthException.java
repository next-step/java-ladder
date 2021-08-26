package labber.exception;

public class UserNameLengthException extends RuntimeException {
    private static String USER_NAME_LENGTH_EXCEPTION = "사용자 이름은 5글자 이하로 생성 가능";

    public UserNameLengthException() {
        super(USER_NAME_LENGTH_EXCEPTION);
    }
}
