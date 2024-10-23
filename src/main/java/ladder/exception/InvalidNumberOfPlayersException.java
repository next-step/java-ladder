package ladder.exception;

public class InvalidNumberOfPlayersException extends RuntimeException {

    private static final String INVALID_NUMBER_OF_PLAYERS_EXCEPTION_MESSAGE = "플레이어 수는 1명 이상입니다.";

    public InvalidNumberOfPlayersException() {
        super(INVALID_NUMBER_OF_PLAYERS_EXCEPTION_MESSAGE);
    }
}
