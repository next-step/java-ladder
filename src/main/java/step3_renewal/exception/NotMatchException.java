package step3_renewal.exception;

public class NotMatchException extends IllegalArgumentException {
    public NotMatchException(final int participantCount, final int rewardCount) {
        super(String.format("참여자와 리워드 보상수가 일치하지 않습니다. (참여자 수: %d, 리워드 수: %d)", participantCount, rewardCount));
    }
}
