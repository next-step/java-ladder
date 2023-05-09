package ladder.domain;

import java.util.Objects;

public class Result {

	private final String result;

	public Result(String result) {
		if (result.isBlank()) {
			throw new IllegalArgumentException("실행 결과는 빈값일 수 없습니다.");
		}
		if (this.isValidString(result) == false && this.isNumeric(result) == false) {
			throw new IllegalArgumentException("실행 결과는 `꽝`이나 `숫자`만 입력할 수 있습니다.");
		}
		this.result = result;
	}

	private boolean isValidString(String result) {
		return result.equals("꽝");
	}

	private boolean isNumeric(String result) {
		try {
			Integer.parseInt(result);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public String getResult() {
		return result;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Result result1 = (Result)o;
		return Objects.equals(result, result1.result);
	}

	@Override
	public int hashCode() {
		return Objects.hash(result);
	}
}
