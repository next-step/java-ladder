package nextstep.ladder.domain.exceptions;

public class NotNumberStringIsNotAllowException extends IllegalArgumentException {
    public NotNumberStringIsNotAllowException() {
        super("숫자가 아닌 문자열은 허용되지 않습니다.");
    }
}
