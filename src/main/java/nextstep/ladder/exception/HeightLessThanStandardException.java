package nextstep.ladder.exception;

public class HeightLessThanStandardException extends IllegalArgumentException{
    private static final String MESSAGE = "사다리의 높이는 0보다 커야합니다. (입력된 사다리의 높이: %d)";

    public HeightLessThanStandardException(String message) {
        super(message);
    }

    public HeightLessThanStandardException(int height) {
        this(String.format(MESSAGE, height));
    }
}
