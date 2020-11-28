package step2.exception;

public class LadderHeightException extends IllegalArgumentException {

    public static final String LADDER_HEIGHT_EXCEPTION = "사다리의 높이는 최소 1개입니다.";

    public LadderHeightException() {
        super(LADDER_HEIGHT_EXCEPTION);
    }
}
