package ladder.domain.result;

import java.util.Objects;

public class Result {
	private final String value;

	public Result(String value) {
		if (value == null || value.isEmpty()) {
			throw new IllegalArgumentException("결과 값은 null이나 빈 문자열이 될 수 없습니다.");
		}
		if (!value.equals("꽝") && !value.matches("[0-9]+")) {
			throw new IllegalArgumentException("결과값은 꽝 또는 숫자가 와야합니다.");
		}
		this.value = value;
	}

	public static Result createResult(final String value) {
		return new Result(value);
	}

	@Override
	public boolean equals(final Object object) {
		if (this == object) return true;
		if (object == null || getClass() != object.getClass()) return false;
		final Result result = (Result) object;
		return Objects.equals(value, result.value);
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}

    public String getValue() {
		return value;
    }

	public String getValueWithSpace() {
		return String.format("%-" + 6 + "s", value);
	}
}
