package nextstep.ladder.step4.exception;

public class LineMinimumLengthException extends IllegalArgumentException {

    public static final int MINIMUM_LENGTH = 2;

    private static final String MESSAGE = "사다리 최소 길이(%d)보다 작을 수 없습니다.";

    public LineMinimumLengthException() {
        super(String.format(MESSAGE, MINIMUM_LENGTH));
    }

}
