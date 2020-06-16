package ladder.domain;

public class RewardsCountException extends RuntimeException {
    public static final String MESSAGE = "참가자 수와 결과 보상 수가 같지 않습니다.";

    public RewardsCountException() {
        super(MESSAGE);
    }
}
