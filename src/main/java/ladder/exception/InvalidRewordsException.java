package ladder.exception;

public class InvalidRewordsException extends RuntimeException {

    public InvalidRewordsException() {
        super("리워드 수가 사람 수와 맞지 않습니다.");
    }

}
