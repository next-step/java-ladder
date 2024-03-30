package laddergame.exception;

import static laddergame.domain.Player.MAX_NAME_LENGTH;

public class InvalidPlayerException extends IllegalArgumentException {
    private static final String WRONG_PLAYER_NAME_MESSAGE = "(%s): 참여자의 이름은 최대 %d글자이어야 합니다.";

    public InvalidPlayerException(String wrongInput) {
        super(String.format(WRONG_PLAYER_NAME_MESSAGE, wrongInput, MAX_NAME_LENGTH));
    }
}
