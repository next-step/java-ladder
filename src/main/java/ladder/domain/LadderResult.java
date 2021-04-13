package ladder.domain;

import java.util.HashMap;
import java.util.Map;

public class LadderResult {
	private static final String NO_EXISTS_PLAYER = "존재하지 않는 플레이어입니다.";

	private final Map<String, String> results = new HashMap<>();

	public LadderResult(Ladder ladder, Players players, InputResult inputResults) {
		for (int playerStartPosition = 0; playerStartPosition < players.size(); playerStartPosition++) {
			int resultPoint = ladder.moveLine(playerStartPosition);
			mappingResultToPlayer(players.getPlayerName(playerStartPosition), inputResults.getResult(resultPoint));
		}
	}

	private void mappingResultToPlayer(String playerName, String result) {
		results.put(playerName, result);
	}

	public String getResult(String playerName) {
		return results.getOrDefault(playerName, NO_EXISTS_PLAYER);
	}

	public Map<String, String> getAllResult() {
		return results;
	}
}
