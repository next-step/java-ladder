package step2.exception;

public class NotMoveLeftException extends IllegalArgumentException{
    public NotMoveLeftException() {
        super("왼쪽으로 움직일수 없습니다.");
    }
}
