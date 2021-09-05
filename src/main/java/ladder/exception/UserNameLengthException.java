package ladder.exception;

public class UserNameLengthException extends RuntimeException {
    private static String USER_NAME_LENGTH_EXCEPTION = "사용자 이름은 5글자 이하로 생성 가능 입력한 이름 : %s";

    public UserNameLengthException(String name) {
        super(String.format(USER_NAME_LENGTH_EXCEPTION, name));
    }
}
