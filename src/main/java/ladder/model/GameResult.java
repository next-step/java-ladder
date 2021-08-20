package ladder.model;

import java.util.Objects;

public class GameResult {

	private final Player player;
	private final int position;

	public GameResult(Player player, int position) {
		this.player = player;
		this.position = position;
	}

	public boolean isExist(String name) {
		return player.isExist(name);
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
		return position == that.position && Objects.equals(player, that.player);
	}

	@Override
	public int hashCode() {
		return Objects.hash(player, position);
	}
}
