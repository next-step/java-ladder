package step4.ladderGame.domain.exception;

public class HeightLowException extends IllegalArgumentException {

    private static final String HEIGHT_LOW_EXCEPTION_ERROR_MESSAGE = "사다리 높이는 1 이상이어야 합니다.";

    public HeightLowException() {
        super(HEIGHT_LOW_EXCEPTION_ERROR_MESSAGE);
    }

}
