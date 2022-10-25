package ladder.domain.exception;

public class NameLengthOutOfRangeException extends RuntimeException {

    public static final String MESSAGE_FORMAT = "이름 길이가 범위를 벗어났습니다. 오류이름 : %s";

    public NameLengthOutOfRangeException() {
        super(String.format(MESSAGE_FORMAT, "비어있음"));
    }

    public NameLengthOutOfRangeException(String name) {
        super(String.format(MESSAGE_FORMAT, name));
    }
}
