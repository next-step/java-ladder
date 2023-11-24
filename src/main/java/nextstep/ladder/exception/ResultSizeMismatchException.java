package nextstep.ladder.exception;

public class ResultSizeMismatchException extends RuntimeException{

    public ResultSizeMismatchException() {
        super("결과의 개수와 참여자의 수가 일치하지 않습니다.");
    }
}
