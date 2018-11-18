package laddergame.domain;

public class LadderResult {

	private Player player;
	private Result result;

	public LadderResult(Player player, Result result) {
		this.player = player;
		this.result = result;
	}

	public String getResult() {
		return result.toString();
	}

	public String getFormattedResult() {
		return String.format("%s : %s", player.toString(), result.toString());
	}
}
