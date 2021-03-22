package nextstep.ladder.exception;

public enum UserExceptionMesssage {
	NAME_SIZE_CHECK_FIVE("이름은 5자가 넘어야됩니다."),
	DELIMETER_WITHIN_COMMA(", 로 구분자가 되어야됩니다."),
	NEGATIVE_NOT_AGRRESIVE("음수는 사다리높이로 설정 할 수 없습니다."),
	NOT_NUMERIC_OR_FALSY("숫자나 꽝만 입력 가능합니다."),
	NO_MATCH_PRIZE("상과 참가자 숫자가 맞지않습니다."),
	NO_PARTICIPANT("참가자가 아닙니다.");

	private final String message;

	UserExceptionMesssage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
