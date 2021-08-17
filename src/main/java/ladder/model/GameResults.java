package ladder.model;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import ladder.message.ErrorMessage;

public class GameResults {

	private final List<GameResult> gameResults;

	public GameResults(List<GameResult> gameResults) {
		this.gameResults = Collections.unmodifiableList(gameResults);
	}

	public List<GameResult> findResultOfPerson(Player player) {
		if (player.getPlayerName().equals("all")) {
			return gameResults;
		}
		return getGameResultPlayer(player);
	}

	private List<GameResult> getGameResultPlayer(Player player) {
		checkPlayerExist(player);
		return gameResults.stream()
			.filter(gameResult -> gameResult.getPlayer().equals(player))
			.collect(Collectors.toList());
	}

	private void checkPlayerExist(Player player) {
		gameResults.stream()
			.filter((gameResult) -> gameResult.getPlayer().equals(player))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException(ErrorMessage.NOT_FIND_PLAYER_ERROR_MESSAGE));
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		GameResults that = (GameResults)o;
		return Objects.equals(gameResults, that.gameResults);
	}

	@Override
	public int hashCode() {
		return Objects.hash(gameResults);
	}
}
