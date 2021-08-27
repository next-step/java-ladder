package nextstep.ladder.exception;

public class NotEnoughtWinningPrizeException extends IllegalArgumentException {

    public NotEnoughtWinningPrizeException() {
        super("참여 할 사람과 같은 수의 우승상품을 입력해주세요.");
    }
}
