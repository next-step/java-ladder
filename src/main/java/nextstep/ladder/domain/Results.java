package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Results {
	private final List<Result> results;

	public Results(List<Result> results) {
		this.results = results;
	}

	public Results(String str) {
		this.results = Arrays.stream(str.split(","))
			.map(Result::new)
			.collect(Collectors.toList());
	}

	public List<Result> values() {
		return results;
	}
}
