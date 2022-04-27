package ladder.exception;

public class InvalidUsernameException extends RuntimeException {

    private static final String INVALID_USERNAME_MESSAGE_FORMAT = "사용자 이름은 최대5글자까지 부여할 수 있습니다 : %s";

    public InvalidUsernameException(String username) {
        super(String.format(INVALID_USERNAME_MESSAGE_FORMAT, username));
    }

}
