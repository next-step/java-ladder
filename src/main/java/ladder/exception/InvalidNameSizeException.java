package ladder.exception;

public final class InvalidNameSizeException extends RuntimeException {

    private final String EXCEPTION_FORMAT_MESSAGE = "(%s)와 같이 5글자가 초과된 이름은 사용할 수 없습니다.";

    public InvalidNameSizeException(final String message)  {
        super(message);
    }

    @Override
    public String getMessage() {
        return String.format(EXCEPTION_FORMAT_MESSAGE, super.getMessage());
    }

}
