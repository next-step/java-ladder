package step3.exception;

public class RewardToLessException extends IllegalArgumentException {
    public RewardToLessException(final int participantCount, final int rewardCount) {
        super(String.format("참여자 수 보다 리워드 보상이 적습니다. (참여자: %d, 리워드: %d)", participantCount, rewardCount));
    }
}
