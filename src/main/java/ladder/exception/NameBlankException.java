package ladder.exception;

public class NameBlankException extends IllegalArgumentException {

    private static final String MESSAGE = "사람 이름은 빈값일 수 없습니다";

    public NameBlankException() {
        super(MESSAGE);
    }

}
