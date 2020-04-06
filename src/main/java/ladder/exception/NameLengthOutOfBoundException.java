package ladder.exception;

public class NameLengthOutOfBoundException extends IllegalArgumentException {
    private static final String MESSAGE = "이름의 길이가 5글자를 넘었습니다. : %s";

    public NameLengthOutOfBoundException(String causativeValue) {
        super(String.format(MESSAGE, causativeValue));
    }
}
