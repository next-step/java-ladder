package nextstep.ladder.domain;

public class ContinuousRowException extends RuntimeException {
    private static final String MESSAGE = "사다리 행이 연속으로 존재합니다.";

    public ContinuousRowException() {
        super(MESSAGE);
    }
}
