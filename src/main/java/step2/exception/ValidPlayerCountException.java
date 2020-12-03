package step2.exception;

public class ValidPlayerCountException extends IllegalArgumentException {

    public static final String PLAYER_COUNT_EXCEPTION = "최소 참가인원은 1명입니다.";

    public ValidPlayerCountException() {
        super(PLAYER_COUNT_EXCEPTION);
    }
}
