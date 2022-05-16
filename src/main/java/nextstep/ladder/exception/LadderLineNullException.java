package nextstep.ladder.exception;

public class LadderLineNullException extends IllegalArgumentException{
    private static final String MESSAGE = "사다리의 라인이 비어있습니다.";

    public LadderLineNullException() {
        super(MESSAGE);
    }
}
