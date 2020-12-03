package step2.exception;

public class ValidPositionException extends IllegalArgumentException{

    public static final String VALID_POSITION = "유효한 포지션이 아닙니다.";

    public ValidPositionException() {
        super(VALID_POSITION);
    }
}
