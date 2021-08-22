package nextstep.ladder.exception;

public class InvalidNameLengthException extends RuntimeException {

	private static final String MESSAGE = "이름의 길이는 1 이상 5 이하여야 합니다. (현재 길이 : %d)";
	
	public InvalidNameLengthException(int lengthOfName) {
		super(String.format(MESSAGE, lengthOfName));
	}
}
