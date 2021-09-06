package ladder.exception;

public class WinningItemsException extends RuntimeException {
    private static final String WINNING_ITEMS_EXCEPTION = "당첨 아이템 이름을 입력 하지 않았습니다.";

    public WinningItemsException() {
        super(WINNING_ITEMS_EXCEPTION);
    }
}
