package step2.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import step2.domain.ladder.Ladder;
import step2.domain.player.Players;
import step2.util.ErrorTarget;
import step2.util.Validator;

public class LadderGame {

	private static final String END_FLAG = "ALL";

	private final Players players;
	private final ExecutionResults executionResults;

	public LadderGame(List<String> playersInput, List<String> executionResultsInput) {
		Validator.notNull(playersInput, ErrorTarget.PLAYERS);
		Validator.notNull(executionResultsInput, ErrorTarget.EXECUTION_RESULT_LIST);

		this.players = new Players(playersInput);
		this.executionResults = new ExecutionResults(executionResultsInput, players.numberOfPlayer());
	}

	public int numberOfPlayer() {
		return players.numberOfPlayer();
	}

	public boolean isEnd(String playerName) {
		return END_FLAG.equals(playerName);
	}

	public String personalResult(Ladder ladder, String playerName) {
		int indexByName = players.findIndexByName(playerName);
		int resultIndex = ladder.calculateResultIndex(indexByName);
		return executionResults.toResult(resultIndex);
	}

	public Map<String, String> gameResult(Ladder ladder) {
		Map<String, String> gameResult = new LinkedHashMap<>();
		for (int index = 0; index < players.numberOfPlayer(); index++) {
			String playerName = players.findPlayerNameByIndex(index);
			String result = executionResults.toResult(ladder.calculateResultIndex(index));
			gameResult.put(playerName, result);
		}
		return gameResult;
	}

	public Players getPlayers() {
		return players;
	}

	public ExecutionResults getExecutionResults() {
		return executionResults;
	}
}
