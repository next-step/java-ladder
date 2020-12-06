package ladder.exception;

public class RewardToLessException extends IllegalArgumentException {
    public RewardToLessException() {
        super("참여자 수 보다 리워드 보상이 적습니다.");
    }
}
