package step4.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameResults {
	private final List<String> results;

	private GameResults(List<String> result) {
		this.results = new ArrayList<>(result);
	}

	public static GameResults of(String[] results) {
		return new GameResults(Arrays.asList(results));
	}

	public int size() {
		return this.results.size();
	}

	public String getResultOf(int index) {
		return results.get(index);
	}
}
