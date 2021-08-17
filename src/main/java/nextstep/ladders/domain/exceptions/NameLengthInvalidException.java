package nextstep.ladders.domain.exceptions;

public class NameLengthInvalidException extends RuntimeException {

    public NameLengthInvalidException() {
        super("이름은 5글자를 초과할 수 없습니다.");
    }
}
