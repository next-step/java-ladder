package step2.util;

import java.util.function.Supplier;

public enum ErrorTarget implements Supplier<String> {
	NAME_INPUT("이름 입력"),
	DIRECTION("방향"),
	DIRECTION_LIST("방향 리스트"),
	HEIGHT("사다리높이"),
	PREVIOUS_POINT("이전 포인트"),
	SUPPLIER("생성 전략");

	private final String message;

	ErrorTarget(String message) {
		this.message = message;
	}

	@Override
	public String get() {
		return message;
	}
}
