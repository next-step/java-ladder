package ladder.domain.result;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Results {
	private final List<Result> results;

	public Results(final String resultValues, final int namesSize) {
		String[] results = resultValues.split(",");
		if (results.length != namesSize) {
			throw new IllegalArgumentException("결과 값은 사람의 숫자와 같아야 합니다.");
		}
		this.results = Arrays.stream(results)
				.map(Result::createResult)
				.collect(Collectors.toList());
	}

	public Results(List<Result> results) {
		this.results = results;
	}

	public static Results createResults(final String resultValues, final int namesSize) {
		return new Results(resultValues, namesSize);
	}

	public List<Result> getResults() {
		return results;
	}

	public Result getResult(int resultIndex) {
		return results.get(resultIndex);
	}
}
