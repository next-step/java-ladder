package ladder.exception;

public final class InputNegativeNumberException extends RuntimeException {

    private final String EXCEPTION_FORMAT_MESSAGE = "(%s)이라는 음수의 값이 입력되었습니다.";

    public InputNegativeNumberException(final int message) {
        super(String.valueOf(message));
    }

    @Override
    public String getMessage() {
        return String.format(EXCEPTION_FORMAT_MESSAGE, super.getMessage());
    }

}
