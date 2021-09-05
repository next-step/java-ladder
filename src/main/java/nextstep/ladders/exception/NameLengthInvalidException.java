package nextstep.ladders.exception;

public class NameLengthInvalidException extends RuntimeException {

    public NameLengthInvalidException() {
        super("이름은 5글자를 초과할 수 없습니다.");
    }
}
