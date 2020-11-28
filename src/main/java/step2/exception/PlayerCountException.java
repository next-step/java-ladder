package step2.exception;

public class PlayerCountException extends IllegalArgumentException{

    public static final String PLAYER_COUNT_EXCEPTION = "사람은 최소 한명 이상이여야 합니다.";

    public PlayerCountException() {
        super(PLAYER_COUNT_EXCEPTION);
    }
}
