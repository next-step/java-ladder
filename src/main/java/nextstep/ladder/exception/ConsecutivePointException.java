package nextstep.ladder.exception;

public class ConsecutivePointException extends IllegalArgumentException {

    public ConsecutivePointException() {
        super("왼쪽과 오른쪽으로 모두 이동 가능한 포인트는 생성할 수 없습니다.");
    }
}
