package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
	List<Player> players;

	public Players(String players) {
		this(Arrays.stream(players.split(",")).map(Player::new).toArray(Player[]::new));
	}

	public Players(Player... args) {
		this.players = Arrays.stream(args).collect(Collectors.toList());
	}

	public List<Player> getPlayers() {
		return players;
	}
}
