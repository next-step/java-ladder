package nextstep.ladder.domain.exceptions;

public class ExceedMaxNameLengthException extends IllegalArgumentException {
    public ExceedMaxNameLengthException() {
        super("이름 최대 길이를 초과했습니다.");
    }

}
