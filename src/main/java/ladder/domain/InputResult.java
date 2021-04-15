package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputResult {
	private final List<String> inputResults;

	public InputResult(String inputResults, int playerSize) {
		validateInputResult(inputResults, playerSize);
		this.inputResults = Arrays.stream(inputResults.split(","))
			.map(String::trim)
			.collect(Collectors.toList());
	}

	private void validateInputResult(String inputResults, int playerSize) {
		if (inputResults.split(",").length != playerSize) {
			throw new IllegalArgumentException("결과값의 갯수와 플레이어 수가 일치해야 합니다.");
		}
	}

	public List<String> getInputResults() {
		return inputResults;
	}

	public String getResult(int resultPoint) {
		return this.inputResults.get(resultPoint);
	}
}
