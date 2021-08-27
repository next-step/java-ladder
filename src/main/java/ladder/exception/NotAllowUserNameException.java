package ladder.exception;

public class NotAllowUserNameException extends IllegalArgumentException {

    private static final String MESSAGE = "허용되지 않는 이름입니다.";

    public NotAllowUserNameException() {
        super(MESSAGE);
    }
}