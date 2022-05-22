package nextstep.ladder.exception;

public class LadderLengthException extends RuntimeException {

    private static final String MINIMUM_LINE_MESSAGE = "사다리 행열의 길이는 최소 2 이상입니다.";

    public LadderLengthException() {
        super(MINIMUM_LINE_MESSAGE);
    }
}
