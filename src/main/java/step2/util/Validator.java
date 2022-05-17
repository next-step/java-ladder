package step2.util;

public class Validator {

	private Validator() {
		throw new AssertionError("인스턴스화 할 수 없습니다.");
	}

	public static <T> void notNull(T value) {
		if (value == null) {
			throw new IllegalArgumentException("입력 값이 널 입니다.");
		}
	}

	public static void notBlank(String input) {
		if (input == null || input.isBlank()) {
			throw new IllegalArgumentException("입력 값이 공백입니다.");
		}
	}
}
