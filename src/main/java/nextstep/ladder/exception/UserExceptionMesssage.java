package nextstep.ladder.exception;

public enum UserExceptionMesssage {
	NAME_SIZE_CHECK_FIVE("이름은 5자가 넘어야됩니다."),
	DELIMETER_WITHIN_COMMA(", 로 구분자가 되어야됩니다."),
	NEGATIVE_NOT_AGRRESIVE("음수는 사다리높이로 설정 할 수 없습니다.");

	private final String message;

	UserExceptionMesssage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
