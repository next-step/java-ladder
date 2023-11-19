package ladder.exception;

public class NegativeHeightException extends IllegalArgumentException {

    private static final String MESSAGE = "사다리 높이는 음수일 수 없습니다";

    public NegativeHeightException() {
        super(MESSAGE);
    }

}
