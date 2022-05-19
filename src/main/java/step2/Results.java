package step2;

import java.util.List;
import java.util.Objects;

import step2.util.ErrorTarget;
import step2.util.Validator;

public class Results {

	private static final int MAX_LENGTH = 5;

	private final List<String> values;

	public Results(List<String> results, int numberOfPlayer) {
		Validator.notNull(results, ErrorTarget.RESULT_LIST);
		Validator.equivalent(results.size(), numberOfPlayer,
			String.format("입력한 실행 결과의 갯수(%d)와 플레이어의 수(%d)가 다릅니다.", results.size(), numberOfPlayer));
		results.forEach(result -> Validator.max(MAX_LENGTH, result.length(),
			String.format("이름이 최대 길이는 %d 글자 입니다. 입력 : %s", MAX_LENGTH, result)));

		this.values = results;
	}

	public List<String> getValues() {
		return values;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Results results = (Results)o;
		return Objects.equals(values, results.values);
	}

	@Override
	public int hashCode() {
		return Objects.hash(values);
	}
}
