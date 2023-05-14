package ladder.exception;

public class IllegalPlayerNameException extends RuntimeException {
    private static final String DEFAULT_MESSAGE = "플레이어 이름은 5자를 초과할 수 없습니다.";

    public IllegalPlayerNameException(String message) {
        super(String.format("%s %s", DEFAULT_MESSAGE, message));
    }
}
