package step2.exception;

public class NotMatchPlayerRewardsCountException extends IllegalArgumentException {
    public NotMatchPlayerRewardsCountException() {
        super("플레이어 숫자와 상품의 숫자가 맞지 않습니다.");
    }
}
