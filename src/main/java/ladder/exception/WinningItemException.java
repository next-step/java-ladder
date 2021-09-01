package ladder.exception;

public class WinningItemException extends RuntimeException {
    private static final String WINNING_ITEM_EXCEPTION = "아이템 이름이 잘못 되었습니다.";

    public WinningItemException() {
        super(WINNING_ITEM_EXCEPTION);
    }
}
