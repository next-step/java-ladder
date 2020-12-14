package ladder.exception;

public class InvalidPositionNumberException extends RuntimeException{

    private static final String MESSAGE = "은 유효하지 않는 숫자입니다";

    public InvalidPositionNumberException(int number){
        super(number + MESSAGE);
    }
}
