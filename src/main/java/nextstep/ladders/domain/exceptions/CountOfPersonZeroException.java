package nextstep.ladders.domain.exceptions;

public class CountOfPersonZeroException extends RuntimeException {

    public CountOfPersonZeroException() {
        super("사람이 0명인 라인을 만들 수 없습니다.");
    }
}