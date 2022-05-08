package ladder.exception;

public class InvalidNumberOfResultException extends RuntimeException {
    private static final String MESSAGE = "실행 결과는 참가자 수와 같아야 합니다(참가자 수: %s, 실행 결과: %s).";

    public InvalidNumberOfResultException(int numberOfResult, int numberOfParticipants) {
        super(String.format(MESSAGE, numberOfParticipants, numberOfResult));
    }
}
