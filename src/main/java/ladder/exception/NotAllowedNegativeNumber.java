package ladder.exception;

public class NotAllowedNegativeNumber extends RuntimeException {
    public static final String NOT_ALLOWED_NEGATIVE_NUMBER_MESSAGE = "좌표에 음수는 입력될 수 없습니다.";
    public NotAllowedNegativeNumber(String message) {
        super(message);
    }
}
