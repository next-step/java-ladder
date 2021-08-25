package nextstep.ladder.exception;

public class InvalidFirstPointException extends RuntimeException {

	private static final String MESSAGE = "첫 번째 지점에서는 왼쪽으로 이동할 수 없습니다.";

	public InvalidFirstPointException() {
		super(MESSAGE);
	}
}
