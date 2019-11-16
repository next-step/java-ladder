package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Participants {

	private final static int MIN_NAME_LENGTH = 1;

	private final List<String> names;

	public Participants(String[] inputNames) {
		validateInputNames(inputNames);
		this.names = new ArrayList<>(Arrays.asList(inputNames));
	}

	private void validateInputNames(String[] inputNames) {
		for (String name : inputNames) {
			validateInputLength(name);
		}
	}

	private void validateInputLength(String name) {
		if (name.length() < MIN_NAME_LENGTH) {
			throw new IllegalArgumentException("이름은 최소 한 자 이상이어야 합니다");
		}
	}

	List<String> getNames() {
		return new ArrayList<>(names);
	}

	int count() {
		return names.size();
	}

}
