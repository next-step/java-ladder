package nextstep.ladder.domain;

import java.util.HashMap;
import java.util.Map;

public class GameResults {
	private final Map<Integer, Integer> gameResults;

	public GameResults() {
		this.gameResults = new HashMap<>();
	}

	public GameResults(Map<Integer, Integer> gameResults) {
		this.gameResults = gameResults;
	}

	public Map<Integer, Integer> values() {
		return gameResults;
	}

	public void put(int userIndex, int resultIndex) {
		gameResults.put(userIndex, resultIndex);
	}
}
