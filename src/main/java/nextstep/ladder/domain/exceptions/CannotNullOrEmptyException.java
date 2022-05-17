package nextstep.ladder.domain.exceptions;

public class CannotNullOrEmptyException extends IllegalArgumentException {
    public CannotNullOrEmptyException() {
        super("null이거나 비어있을 수 없습니다.");
    }

}

