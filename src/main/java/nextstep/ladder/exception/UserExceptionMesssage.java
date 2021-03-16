package nextstep.ladder.exception;

public enum UserExceptionMesssage {
	NAME_SIZE_CHECK_FIVE("이름은 5자가 넘어야됩니다."),
	DELIMETER_WITHIN_COMMA(", 로 구분자가 되어야됩니다.");

	private final String message;

	UserExceptionMesssage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
