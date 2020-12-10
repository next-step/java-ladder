package ladder.exception;

public class InValidUserNameException extends RuntimeException {

    private static final String MESSAGE = " 유효하지 않는 이름형식입니다";

    public InValidUserNameException(String userName) {
        super(userName + MESSAGE);
    }
}
