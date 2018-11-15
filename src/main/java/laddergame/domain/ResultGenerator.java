package laddergame.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ResultGenerator {

	public static List<Result> generate(String rawResults) {
		return Arrays.stream(rawResults.split("[, ]+"))
				.map(Result::new)
				.collect(Collectors.toList());
	}
}
