package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Participants {

	private final List<String> names;

	public Participants(String[] inputNames) {
		this.names = new ArrayList<>(Arrays.asList(inputNames));
	}

	public List<String> getNames() {
		return new ArrayList<>(names);
	}

	public int count() {
		return names.size();
	}

}
