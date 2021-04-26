package ladder.exception;

public final class InvalidIdentifierNameException extends RuntimeException {

    private final String EXCEPTION_FORMAT_MESSAGE = "(%s)과 같은 특정 명령어는 이름으로 사용할 수 없습니다.";

    public InvalidIdentifierNameException(final String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return String.format(EXCEPTION_FORMAT_MESSAGE, super.getMessage());
    }
}
