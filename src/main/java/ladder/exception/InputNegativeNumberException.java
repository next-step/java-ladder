package ladder.exception;

public final class InputNegativeNumberException extends RuntimeException{

    private final String message = "음수의 값이 입력되었습니다.";

    @Override
    public final String getMessage() {
        return message;
    }
}
