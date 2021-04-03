package nextstep.ladder.domain.line.exception;

public class PointAlreadyConnectedException extends RuntimeException {

    private static final String MESSAGE = "이미 다른 지점과 연결되어 있습니다.";

    public PointAlreadyConnectedException() {
        super(MESSAGE);
    }
}
