package ladder.exception;

public class LadderRewardsException extends IllegalArgumentException {
    private static final String MESSAGE = "결과값은 NULL 이 될 수 없습니다.";

    public LadderRewardsException() {
        super(MESSAGE);
    }
}
