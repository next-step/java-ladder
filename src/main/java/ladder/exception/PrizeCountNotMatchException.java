package ladder.exception;

public class PrizeCountNotMatchException extends IllegalArgumentException {
    private static final String MESSAGE = "참여자와 입력 결과의 수는 동일해야 합니다. : %d";

    public PrizeCountNotMatchException(int causativeValue) {
        super(String.format(MESSAGE, causativeValue));
    }
}
