package ladder.view;

public class InvalidInputNumberException extends IllegalArgumentException {
    public InvalidInputNumberException() {
        super("높이는 숫자만 입력할 수 있습니다.");
    }
}
