package nextstep.step4.exception;

public class InvalidHeightException extends RuntimeException {

	private static final String MESSAGE = "사다리의 높이는 1 이상이어야 합니다. (현재 높이 : %d)";

	public InvalidHeightException(int height) {
		super(String.format(MESSAGE, height));
	}
}
