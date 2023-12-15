package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Results {
	private final List<Result> results;

	public Results(List<Result> results, Width width) {
		this.results = results;
		isSameSize(width);
	}

	public Results(String str, Width width) {
		this.results = Arrays.stream(str.split(","))
			.map(Result::new)
			.collect(Collectors.toList());
		isSameSize(width);
	}

	public List<Result> values() {
		return results;
	}

	public void isSameSize(Width width) {
		if (results.size() != width.value()) {
			throw new IllegalArgumentException("참가자 수와 당첨 결과 수는 같아야합니다.");
		}
	}
}
