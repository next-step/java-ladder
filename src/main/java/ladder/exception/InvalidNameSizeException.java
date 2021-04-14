package ladder.exception;

public final class InvalidNameSizeException extends RuntimeException{

    private final String message = "이름이 5글자를 초과했습니다.";

    @Override
    public final String getMessage() {
        return message;
    }
}
