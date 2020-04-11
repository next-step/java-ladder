package ladder.view;

public class InvalidHeightException extends IllegalArgumentException {
    public InvalidHeightException() {
        super("높이는 숫자만 입력할 수 있습니다.");
    }
}
