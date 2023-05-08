package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Results {

	private static final String DELIMITER = ",";

	private final List<Result> results = new ArrayList<>();

	public Results(String inputResults, Names names) {
		Arrays.stream(inputResults.trim().split(Results.DELIMITER))
			.map(String::trim)
			.forEach(result -> this.results.add(new Result(result)));

		if (this.size() != names.countOfPerson()) {
			throw new IllegalArgumentException("실행결과 목록과 참여자 수는 크기가 같아야 합니다.");
		}
	}

	public int size() {
		return this.results.size();
	}

	public List<Result> getResults() {
		return results;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Results results1 = (Results)o;
		return Objects.equals(results, results1.results);
	}

	@Override
	public int hashCode() {
		return Objects.hash(results);
	}
}
