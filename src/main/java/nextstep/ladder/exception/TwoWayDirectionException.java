package nextstep.ladder.exception;

public class TwoWayDirectionException extends RuntimeException {

    private static final String TWO_WAY_DIRECTION_MESSAGE = "왼쪽 혹은 오른쪽 중 한 방향으로만 이동 가능합니다.";

    public TwoWayDirectionException() {
        super(TWO_WAY_DIRECTION_MESSAGE);
    }
}
