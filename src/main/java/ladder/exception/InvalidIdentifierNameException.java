package ladder.exception;

public final class InvalidIdentifierNameException extends RuntimeException {

    private final String FORMAT_MESSAGE = "%s 이란 이름은 사용할 수 없습니다.";

    public InvalidIdentifierNameException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return String.format(FORMAT_MESSAGE, super.getMessage());
    }
}
