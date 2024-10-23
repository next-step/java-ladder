package ladder.exception;

public class InvalidPlayerNameException extends RuntimeException {

    private static final String INVALID_PLAYER_NAME_EXCEPTION_MESSAGE = "플레이어 이름은 1자 이상 5자 이하만 가능합니다.";

    public InvalidPlayerNameException() {
        super(INVALID_PLAYER_NAME_EXCEPTION_MESSAGE);
    }
}
