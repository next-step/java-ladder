package ladder.domain;

import java.util.HashMap;
import java.util.Map;

public class LadderResult {
	private final Map<String, String> results = new HashMap<>();

	public void calculateResult(Ladder ladder, Players players, InputResult inputResult) {

		for (int playerStartPosition = 0; playerStartPosition < players.getPlayers().size(); playerStartPosition++) {
			mappingResultToPlayer(ladder, players, inputResult, playerStartPosition);
		}

	}

	public String getResult(String playerName) {
		return results.get(playerName);
	}

	public Map<String, String> getAllResult() {
		return results;
	}

	private void mappingResultToPlayer(Ladder ladder, Players players, InputResult inputResult,
		int playerStartPosition) {
		int position = playerStartPosition;
		String playerName = players.getPlayers().get(playerStartPosition).toString();

		for (int line = 0; line < ladder.getLadder().size(); line++) {
			position = getPosition(ladder, position, line);
			continue;
		}
		results.put(playerName, inputResult.getInputResults().get(position));
	}

	private int getPosition(Ladder ladder, int position, int line) {
		if (isMove(ladder, position, line)) {
			position += 1;
			return position;
		}
		if (!isMove(ladder, position, line) && isMove(ladder, position - 1, line)) {
			position -= 1;
			return position;
		}
		return position;
	}

	private boolean isMove(Ladder ladder, int position, int i) {
		if (position < 0) {
			return false;
		}
		return ladder.getLadder().get(i).getPoints().get(position);
	}

}
