package step2.exception;

public class NotMoveRightException extends IllegalArgumentException{
    public NotMoveRightException() {
        super("오른쪽으로 움직일수 없습니다.");
    }
}
