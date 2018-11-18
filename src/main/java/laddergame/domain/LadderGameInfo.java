package laddergame.domain;

public class LadderGameInfo {

	public static final String DEFAULT_SEPARATOR = " ";

	private Players players;
	private Results results;

	public LadderGameInfo(Players players, Results results) {
		this.players = players;
		this.results = results;
	}

	public String getFormattedPlayerNames() {
		return players.getFormattedPlayerNames();
	}

	public String getFormattedResults() {
		return results.getFormattedResults();
	}

	public int getPlayerIndex(String playerName) {
		return players.findPlayerIndex(playerName);
	}

	public Player getPlayer(int index) {
		return players.findPlayer(index);
	}

	public Result getResult(int index) {
		return results.findResult(index);
	}

	public int getPlayerCount() {
		return players.getPlayerCount();
	}
}
