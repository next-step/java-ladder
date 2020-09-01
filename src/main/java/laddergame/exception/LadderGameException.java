package laddergame.exception;

public class LadderGameException extends RuntimeException{

	public LadderGameException(String message) {
		super(message);
	}

	public LadderGameException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
