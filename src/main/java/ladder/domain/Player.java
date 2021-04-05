package ladder.domain;

import java.util.Objects;

public class Player {
	private final String playerName;
	private static final int PLAYER_NAME_MAX_SIZE = 5;
	private static final String PLAYER_NAME_MAX_SIZE_ERROR_MSG = "Player Name은 최대 5자입니다.";
	private static final String PLAYER_NAME_MIN_SIZE_ERROR_MSG = "Player Name은 최소 1자 이상이어야 합니다.";

	public Player(String playerName) {
		validatePlayerName(playerName);
		this.playerName = playerName;
	}

	private void validatePlayerName(String playerName) {
		if (playerName.trim().isEmpty()) {
			throw new IllegalArgumentException(PLAYER_NAME_MIN_SIZE_ERROR_MSG);
		}

		if (playerName.length() > PLAYER_NAME_MAX_SIZE) {
			throw new IllegalArgumentException(PLAYER_NAME_MAX_SIZE_ERROR_MSG);
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
