package nextstep.step4.exception;

public class InvalidDirectionException extends RuntimeException {

	private static final String MESSAGE = "방향은 왼쪽 또는 오른쪽 중 하나여야 합니다.";

	public InvalidDirectionException() {
		super(MESSAGE);
	}
}
