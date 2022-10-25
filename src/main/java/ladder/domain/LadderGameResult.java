package ladder.domain;

import java.util.Objects;

/**
 * Created by seungwoo.song on 2022-10-24
 */
public class LadderGameResult {

	private final String value;

	private LadderGameResult(String value) {
		this.value = value;
	}

	public static LadderGameResult of(String value) {
		if ((!"꽝".equals(value) && isNotDigit(value))) {
			throw new IllegalArgumentException("꽝, 또는 숫자만 입력가능 합니다. " + value);
		}

		return new LadderGameResult(value);
	}

	public String getValue() {
		return value;
	}

	private static boolean isNotDigit(String value) {
		return !value.chars().allMatch(Character::isDigit);
	}

	@Override public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		LadderGameResult that = (LadderGameResult)o;
		return Objects.equals(value, that.value);
	}

	@Override public int hashCode() {
		return Objects.hash(value);
	}
}
