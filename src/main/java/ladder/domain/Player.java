package ladder.domain;

import java.util.Objects;

public class Player {
	private final String playerName;

	public Player(String playerName) {
		validatePlayerName(playerName);
		this.playerName = playerName;
	}

	private void validatePlayerName(String playerName) {
		if (playerName.trim().isEmpty()) {
			throw new IllegalArgumentException("Player Name은 최소 1자 이상이어야 합니다.");
		}

		if (playerName.length() > 5) {
			throw new IllegalArgumentException("Player Name은 최대 5자입니다.");
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Player player = (Player)o;
		return Objects.equals(playerName, player.playerName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(playerName);
	}

	@Override
	public String toString() {
		return playerName;
	}
}
