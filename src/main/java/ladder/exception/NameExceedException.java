package ladder.exception;

public class NameExceedException extends IllegalArgumentException {

    private static final String MESSAGE = "사람 이름은 5자를 초과할 수 없습니다";

    public NameExceedException() {
        super(MESSAGE);
    }

}
