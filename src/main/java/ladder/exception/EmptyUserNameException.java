package ladder.exception;

public final class EmptyUserNameException extends IllegalArgumentException {

    private static final String MESSAGE = "유저의 이름을 입력해 주세요.";

    public EmptyUserNameException() {
        super(MESSAGE);
    }
}
