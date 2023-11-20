package nextstep.ladder.exception;

public class BlankNameException extends RuntimeException {

    public BlankNameException() {
        super("이름은 공백이 될 수 없습니다.");
    }
}
