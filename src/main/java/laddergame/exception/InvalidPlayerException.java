package laddergame.exception;

public class InvalidPlayerException extends IllegalArgumentException {
    private static final String WRONG_PLAYER_NAME_MESSAGE = "(%s): 잘못된 참여자 이름입니다.";

    public InvalidPlayerException(String wrongInput) {
        super(String.format(WRONG_PLAYER_NAME_MESSAGE, wrongInput));
    }
}
