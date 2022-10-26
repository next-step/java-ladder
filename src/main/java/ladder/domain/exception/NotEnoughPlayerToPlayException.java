package ladder.domain.exception;

public class NotEnoughPlayerToPlayException extends RuntimeException {

    private static final String MESSAGE_FORMAT = "플레이어가 충분하지 않습니다. 최소인원 : %s";

    public NotEnoughPlayerToPlayException(int minimum) {
        super(String.format(MESSAGE_FORMAT, minimum));
    }
}
