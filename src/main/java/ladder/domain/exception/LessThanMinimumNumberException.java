package ladder.domain.exception;

public class LessThanMinimumNumberException extends RuntimeException {

    private static final String MESSAGE_FORMAT = "최소 숫자 보다 작은 숫자는 입력될 수 없습니다. 최소 숫자 : %s";

    public LessThanMinimumNumberException(int minimum) {
        super(String.format(MESSAGE_FORMAT, minimum));
    }
}
