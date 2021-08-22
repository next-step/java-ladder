package nextstep.ladders.domain.exceptions;

public class HorizontalLinesOverlapException extends RuntimeException {

    public HorizontalLinesOverlapException() {
        super("가로 라인은 겹칠 수 없습니다.");
    }
}
