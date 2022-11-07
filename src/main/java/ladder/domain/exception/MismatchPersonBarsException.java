package ladder.domain.exception;

public class MismatchPersonBarsException extends RuntimeException {

    public MismatchPersonBarsException() {
        super("사람수와 바의 수가 일치하지 않습니다.");
    }
}
