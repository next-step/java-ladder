package ladder.model;

import java.util.Objects;

import ladder.message.ErrorMessage;

public class Result {

	private static final int LIMIT_LENGTH = 6;
	private final String result;

	public Result(String result) {
		checkNull(result);
		checkEmptyResult(result);
		checkResultLimitLength(result);
		this.result = result;
	}

	public String getResult() {
		return result;
	}

	private void checkNull(String result) {
		if (result == null) {
			throw new IllegalArgumentException(ErrorMessage.NULL_ERROR_MESSAGE);
		}
	}

	private void checkEmptyResult(String result) {
		if (result.isEmpty()) {
			throw new IllegalArgumentException(ErrorMessage.EMPTY_ERROR_MESSAGE);
		}
	}

	private void checkResultLimitLength(String result) {
		if (result.length() >= LIMIT_LENGTH) {
			throw new IllegalArgumentException(ErrorMessage.LIMIT_LENGTH_MESSAGE);
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Result result1 = (Result)o;
		return Objects.equals(result, result1.result);
	}

	@Override
	public int hashCode() {
		return Objects.hash(result);
	}
}
