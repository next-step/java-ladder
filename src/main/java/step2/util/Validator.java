package step2.util;

import java.util.Collection;

public class Validator {

	private Validator() {
		throw new AssertionError("인스턴스화 할 수 없습니다.");
	}

	public static <T> void notNull(T value, ErrorTarget target) {
		if (value == null) {
			throw new IllegalArgumentException(target.get() + "- 널 입니다.");
		}
	}

	public static void notBlank(String value, ErrorTarget target) {
		if (value == null || value.isBlank()) {
			throw new IllegalArgumentException(target.get() + "- 널이거나 공백입니다.");
		}
	}

	public static void min(int threshold, int operand, String message) {
		if (operand < threshold) {
			throw new IllegalArgumentException(message);
		}
	}

	public static void max(int threshold, int operand, String message) {
		if (operand > threshold) {
			throw new IllegalArgumentException(message);
		}
	}

	public static void duplicate(Collection<?> collection, String message) {
		long distinct = collection.stream().distinct().count();
		equivalent(distinct, collection.size(), message);
	}

	public static void equivalent(long operand1, int operand2, String message) {
		if (operand1 != operand2) {
			throw new IllegalArgumentException(message);
		}
	}

	public static void equivalent(int operand1, int operand2, String message) {
		equivalent((long)operand1, operand2, message);
	}

}
