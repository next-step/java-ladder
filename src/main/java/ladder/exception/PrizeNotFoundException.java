package ladder.exception;

public class PrizeNotFoundException extends IllegalArgumentException {
    private static final String MESSAGE = "상품을 찾을 수 없습니다.";

    public PrizeNotFoundException() {
        super(MESSAGE);
    }
}
