package ladder.model;

import java.util.Objects;

public class GameResult {

	private final Player player;
	private final int position;

	public GameResult(Player player, int position) {
		this.player = player;
		this.position = position;
	}

	public Player getPlayer() {
		return player;
	}

	public int getPosition() {
		return position;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		GameResult that = (GameResult)o;
		return getPosition() == that.getPosition() && Objects.equals(getPlayer(), that.getPlayer());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getPlayer(), getPosition());
	}

}
