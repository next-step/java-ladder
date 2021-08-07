package ladder.exception;

public class InvalidDirectionException extends RuntimeException {
    private final ErrorType errorType;

    public InvalidDirectionException(ErrorType errorType) {
        super(errorType.message());
        this.errorType = errorType;
    }

    public enum ErrorType {
        NOT_OPENED("왼쪽으로 닫혀있는 줄은 바로 전줄에서 열었어야 합니다."),
        NOT_CLOSED("오른쪽으로 열려있는 줄은 바로 다음줄에서 닫아야 합니다."),
        FIRST_CLOSED("첫번째 줄은 닫힐 수 없습니다."),
        LAST_OPENED("마지막 줄은 열려있을 수 없습니다.");

        private final String message;

        ErrorType(final String message) {
            this.message = message;
        }

        public String message() {
            return message;
        }
    }
}
