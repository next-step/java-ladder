package nextstep.ladder.exception;

public class NameOverLengthException extends RuntimeException {

    public NameOverLengthException() {
        super("이름은 5자 이하여야 합니다.");
    }
}
