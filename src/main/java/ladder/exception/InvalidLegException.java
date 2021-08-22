package ladder.exception;

public class InvalidLegException extends IllegalArgumentException {

    public static final String INVALID_LEG = "사다리 다리는 연속되어 놓일 수 없습니다.";

    public InvalidLegException() {
        this(INVALID_LEG);
    }

    public InvalidLegException(String s) {
        super(s);
    }
}
