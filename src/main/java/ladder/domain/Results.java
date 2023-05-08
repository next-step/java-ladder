package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Results {

	private static final String DELIMITER = ",";

	private final List<Result> results = new ArrayList<>();

	public Results(String inputResults) {
		Arrays.stream(inputResults.trim().split(Results.DELIMITER))
			.map(String::trim)
			.forEach(result -> this.results.add(new Result(result)));
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
