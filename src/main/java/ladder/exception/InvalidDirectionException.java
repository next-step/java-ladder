package ladder.exception;

public class InvalidDirectionException extends RuntimeException {

    private static final String INVALID_DIRECTION_MESSAGE = "두 방향은 선택할 수 없습니다.";

    public InvalidDirectionException() {
        super(INVALID_DIRECTION_MESSAGE);
    }

}
