package nextstep.ladder.exception;

public class ContinousLinePointException extends IllegalArgumentException {

    public ContinousLinePointException() {
        super("가로 선은 연속해서 2개 이상 위치할 수 없습니다.");
    }
}
