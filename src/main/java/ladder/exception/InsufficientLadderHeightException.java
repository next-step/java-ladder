package ladder.exception;

public class InsufficientLadderHeightException extends RuntimeException{

    private static final String MESSAGE = "사다리 높이는 최소 2 이상이어야 합니다";

    public InsufficientLadderHeightException(){
        super(MESSAGE);
    }
}
