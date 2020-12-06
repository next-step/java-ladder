package ladder.exception;

public class RewardToManyException extends IllegalArgumentException {
    public RewardToManyException() {
        super("참여자 수 보다 리워드 보상이 많습니다.");
    }
}
