package ladder.exception;

public class NotFoundRewardException extends RuntimeException{

    private static final String MESSAGE = "당첨번호를 찾지 못하였습니다.";

    public NotFoundRewardException(){
        super(MESSAGE);
    }
}
