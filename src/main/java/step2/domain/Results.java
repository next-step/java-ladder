package step2.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import step2.util.ErrorTarget;
import step2.util.Validator;

public class Results {

	private static final int MIN_INDEX = 0;
	private static final int MAX_LENGTH = 5;

	private final List<String> values = new ArrayList<>();

	public Results(List<String> results, int numberOfPlayer) {
		Validator.notNull(results, ErrorTarget.RESULT_LIST);
		Validator.equivalent(results.size(), numberOfPlayer,
			String.format("입력한 실행 결과의 갯수(%d)와 플레이어의 수(%d)가 다릅니다.", results.size(), numberOfPlayer));
		results.forEach(result -> Validator.max(MAX_LENGTH, result.length(),
			String.format("이름이 최대 길이는 %d 글자 입니다. 입력 : %s", MAX_LENGTH, result)));

		values.addAll(results);
	}

	public String toResult(int calculateResultIndex) {
		Validator.min(MIN_INDEX, calculateResultIndex,
			String.format("실행결과 인덱스가 최솟값(%d)보다 작습니다. 입력 : %d", MIN_INDEX, calculateResultIndex));
		Validator.max(values.size() - 1, calculateResultIndex,
			String.format("실행결과 인덱스가 최댓값(%d)보다 큽니다. 입력 : %d", values.size() - 1, calculateResultIndex));
		return values.get(calculateResultIndex);
	}

	public List<String> getValues() {
		return List.copyOf(values);
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
