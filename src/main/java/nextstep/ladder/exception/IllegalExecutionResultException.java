package nextstep.ladder.exception;

public class IllegalExecutionResultException extends IllegalArgumentException {
    private static final String MESSAGE = "입력된 실행결과의 갯수가 참가자의 수와 다릅니다. (입력된 실행결과의 갯수: %d)";

    public IllegalExecutionResultException(int value) {
        super(String.format(MESSAGE, value));
    }
}
