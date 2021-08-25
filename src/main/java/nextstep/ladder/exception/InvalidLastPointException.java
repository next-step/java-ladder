package nextstep.ladder.exception;

public class InvalidLastPointException extends RuntimeException {

	private static final String MESSAGE = "마지막 지점에서는 오른쪽으로 이동할 수 없습니다.";

	public InvalidLastPointException() {
		super(MESSAGE);
	}
}
