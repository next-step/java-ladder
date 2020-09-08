package step3.domain;

import java.util.*;

public class GameResult {
	private List<String> result;

	private GameResult(List<String> result) {
		this.result = new ArrayList<>(result);
	}

	public static GameResult of(List<String> userName, String[] results) {
		return new GameResult(Arrays.asList(results));
	}

	public int size() {
		return this.result.size();
	}

	public Map<String, String> calculateResult(Ladder ladder) {
		Map<String, String> resultMap = new HashMap<>();
		for (int i = 0; i < ladder.getUsersName().size(); i++) {
			resultMap.put(ladder.getUsersName().get(i), result.get(i));
		}
		return resultMap;
	}
}
