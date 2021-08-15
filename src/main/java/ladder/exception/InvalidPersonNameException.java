package ladder.exception;

public class InvalidPersonNameException extends IllegalArgumentException {
    private static final String MESSAGE = "사람 이름이 5글자를 초과 하였습니다.";

    public InvalidPersonNameException() {
        super(MESSAGE);
    }
}
