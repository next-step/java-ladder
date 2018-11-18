package laddergame.domain;

import static laddergame.domain.LadderGameInfo.DEFAULT_SEPARATOR;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Results {

	private List<Result> results;

	private Results(List<Result> results) {
		this.results = results;
	}

	public static Results fromComma(String rawResults) {
		List<Result> results = Arrays.stream(rawResults.split("[, ]+"))
				.map(Result::new)
				.collect(Collectors.toList());
		return new Results(results);
	}

	public String getFormattedResults() {
		return results.stream()
				.map(result -> result.getFormattedValue())
				.collect(Collectors.joining(DEFAULT_SEPARATOR));
	}

	public Result findResult(int index) {
		return results.get(index);
	}

	public int getResultCount() {
		return results.size();
	}
}
