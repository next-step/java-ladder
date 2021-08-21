package nextstep.ladders.domain.exceptions;

public class OverRowLengthException extends RuntimeException {

    public OverRowLengthException() {
        super("가로 길이보다 긴 곳에서 시작 할 수 없습니다.");
    }
}
