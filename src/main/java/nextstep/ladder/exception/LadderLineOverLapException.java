package nextstep.ladder.exception;

public class LadderLineOverLapException extends RuntimeException {
    private static final String MESSAGE = "사다리 라인 위치가 겹쳐서 생성될 수 없습니다.";

    public LadderLineOverLapException() {
        super(MESSAGE);
    }
}
