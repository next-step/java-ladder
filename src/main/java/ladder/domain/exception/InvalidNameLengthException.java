package ladder.domain.exception;

public class InvalidNameLengthException extends RuntimeException {

    public InvalidNameLengthException() {
        super("이름은 1자 이상 5자 이하입니다.");
    }
}
