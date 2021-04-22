package ladder.exception;

public class InvalidIdentifierNameException extends RuntimeException {

    private final String EXCEPTION_FORMAT_MESSAGE = "%s과 같은 특정 명령어는 이름으로 사용할 수 없습니다.";

    public InvalidIdentifierNameException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return String.format(EXCEPTION_FORMAT_MESSAGE, super.getMessage());
    }
}
