package laddergame.domain;

public class LadderResult implements Printable {

	private Player player;
	private Result result;

	public LadderResult(Player player, Result result) {
		this.player = player;
		this.result = result;
	}

	public String getFormattedResult() {
		return String.format("%s : %s", player.toString(), result.toString());
	}

	@Override
	public String print() {
		return result.toString();
	}
}
