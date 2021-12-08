package nextstep.ladder.exception;

public class DirectionException extends RuntimeException {
    private static final String MESSAGE = "Direction 값이 잘못 되었습니다.";

    public DirectionException() {
        super(MESSAGE);
    }
}
