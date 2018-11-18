package laddergame.domain;

import java.util.Objects;

public class Result {

	private String value;

	public Result(String value) {
		this.value = value;
	}

	public String getFormattedValue() {
		return String.format("%" + Player.MAX_NAME_LENGTH + "s", value);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Result)) {
			return false;
		}
		Result result = (Result) o;
		return Objects.equals(value, result.value);
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}

	@Override
	public String toString() {
		return value;
	}
}
