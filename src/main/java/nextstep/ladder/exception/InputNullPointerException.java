package nextstep.ladder.exception;

public class InputNullPointerException extends NullPointerException {

    private static final String MESSAGE = "해당 값은 필수로 입력하여야 합니다.";

    public InputNullPointerException() {
        super(MESSAGE);
    }

}
