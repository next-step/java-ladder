package nextstep.ladders.domain.exceptions;

public class DifferentCountException extends RuntimeException {

    public DifferentCountException() {
        super("참가자와 실행결과의 개수가 다릅니다.");
    }
}
