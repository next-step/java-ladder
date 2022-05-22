package step2.util;

import java.util.function.Supplier;

public enum ErrorTarget implements Supplier<String> {
	NAME_INPUT("이름 입력"),
	DIRECTION("방향"),
	DIRECTION_LIST("방향 리스트"),
	PREVIOUS_POINT("이전 포인트"),
	SUPPLIER("생성 전략"),
	EXECUTION_RESULT_LIST("실행 결과 리스트"),
	PLAYERS("플레이어 일급 컬렉션"),
	;

	private final String message;

	ErrorTarget(String message) {
		this.message = message;
	}

	@Override
	public String get() {
		return message;
	}
}
