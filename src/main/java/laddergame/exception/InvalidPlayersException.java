package laddergame.exception;

import static laddergame.domain.Players.PLAYERS_MIN_NUMBER;

public class InvalidPlayersException extends IllegalArgumentException {
    private static final String WRONG_SIZE_OF_PLAYERS = "참여자는 %d명 이상이어야 합니다.";

    public InvalidPlayersException() {
        super(String.format(WRONG_SIZE_OF_PLAYERS, PLAYERS_MIN_NUMBER));
    }
}
