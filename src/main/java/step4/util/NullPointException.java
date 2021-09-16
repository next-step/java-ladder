package step4.util;

public class NullPointException extends RuntimeException {

    private static final String NULL_POINT_ERROR_MESSAGE = "null이 들어올 수 없다.";

    public NullPointException() {
        super(NULL_POINT_ERROR_MESSAGE);
    }

}
