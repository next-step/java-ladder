package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class LadderResult {

	private final static int MIN_RESULT_LENGTH = 1;

	private final List<String> result;

	LadderResult(List<String> inputResult) {
		this.result = inputResult;
	}

	LadderResult(String[] inputResult) {
		validateInputResult(inputResult);
		this.result = new ArrayList<>(Arrays.asList(inputResult));
	}

	private void validateInputResult(String[] inputResult) {
		for (String result : inputResult) {
			validateInputLength(result);
		}
	}

	private void validateInputLength(String result) {
		if (result.length() < MIN_RESULT_LENGTH) {
			throw new IllegalArgumentException("이름은 최소 한 자 이상이어야 합니다");
		}
	}

	List<String> getResult() {
		return new ArrayList<>(result);
	}

}
