package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LadderResult {
	private final List<String> results;

	public LadderResult(final String[] result) {
		results = Arrays.stream(result)
			.collect(Collectors.toList());
	}

	public int getResultNumber() {
		return results.size();
	}

	public String getResultByIndex(final int index) {
		return results.get(index);
	}
}
