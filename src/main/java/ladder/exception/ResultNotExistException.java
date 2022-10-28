package ladder.exception;

public class ResultNotExistException extends LadderException {
    public ResultNotExistException() {
        super("결과가 존재하지 않습니다.");
    }
}
