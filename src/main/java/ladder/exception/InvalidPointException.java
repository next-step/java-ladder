package ladder.exception;

public class InvalidPointException extends IllegalArgumentException {

    public static final String INVALID_POINT = "가로 라인이 두번 연속으로 이어질 수 없습니다.";

    public InvalidPointException() {
        this(INVALID_POINT);
    }

    public InvalidPointException(String s) {
        super(s);
    }
}
