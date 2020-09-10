package step3.domain;

import java.util.*;

public class GameResult {
	//////////////////
	private final List<String> result;

	private GameResult(List<String> result) {
		this.result = new ArrayList<>(result);
	}

	public static GameResult of(String[] results) {
		return new GameResult(Arrays.asList(results));
	}
	///////////////

	private Map<String, String> resultMap;

	private GameResult(List<String> names, List<String> results) {
		///////////////
		this.result = results;
		///////////////
		this.resultMap = new LinkedHashMap<>();
		for (int i = 0; i < names.size(); i++) {
			this.resultMap.put(names.get(i), results.get(i));
		}
	}

	public static GameResult of(List<String> names, String[] results) {
		return new GameResult(names, Arrays.asList(results));
	}

	public int size() {
		return this.result.size();
	}

	public void calculateResult(Ladder ladder) {
		for (int i = 0; i < ladder.getUsersName().size(); i++) {
			this.resultMap.put(ladder.getUsersName().get(i), result.get(i));
		}
	}
}
