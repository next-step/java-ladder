package step4.exceptions;

public class UserNumberException extends IllegalArgumentException {
    private static final String USER_NAME = "사다리 게임은 최소한 2개의 값이 존재하여야 합니다.";

    public UserNumberException() {
        super(USER_NAME);
    }
}
