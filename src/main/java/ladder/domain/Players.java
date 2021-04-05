package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
	private final List<Player> players;
	private static final int PLAYER_MIN_SIZE = 2;
	private static final String PLAYER_MIN_SIZE_ERROR_MSG = "참여자는 최소 2명 이상이어야 합니다.";

	public Players(String players) {
		this(Arrays.stream(players.split(",")).map(Player::new).collect(Collectors.toList()));
	}

	public Players(List<Player> players) {
		validatePlayerSize(players.size());
		this.players = players;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public int size() {
		return players.size();
	}

	private void validatePlayerSize(int playerSize) {
		if (playerSize < PLAYER_MIN_SIZE) {
			throw new IllegalArgumentException(PLAYER_MIN_SIZE_ERROR_MSG);
		}
	}

}
