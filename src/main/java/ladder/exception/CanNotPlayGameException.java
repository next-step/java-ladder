package ladder.exception;

public class CanNotPlayGameException extends RuntimeException {

    private static final String MESSAGE = "게임을 시작할 수 없습니다.";

    public CanNotPlayGameException(){
        super(MESSAGE);
    }

}