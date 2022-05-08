package ladder.exception;

public class InvalidNameOfReulstException extends RuntimeException {
    private static final String MESSAGE = "ERROR] 개별 결과는 0자 초과 입니다(입력된 결과: %s).";

    public InvalidNameOfReulstException(String input) {
        super(String.format(MESSAGE, input));
    }
}
