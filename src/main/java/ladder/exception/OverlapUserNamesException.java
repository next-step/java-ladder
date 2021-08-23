package ladder.exception;

public class OverlapUserNamesException extends IllegalArgumentException {

    private static final String MESSAGE = "중복된 유저이름이 있습니다.";

    public OverlapUserNamesException() {
        super(MESSAGE);
    }
}
