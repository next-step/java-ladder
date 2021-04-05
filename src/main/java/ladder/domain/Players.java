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
		validatePlayerSize(args.length);
		this.players = Arrays.stream(args).collect(Collectors.toList());
	}

	public List<Player> getPlayers() {
		return players;
	}

	public int size() {
		return players.size();
	}

	private void validatePlayerSize(int playerSize) {
		if (playerSize <= 1) {
			throw new IllegalArgumentException("참여자는 최소 2명 이상이어야 합니다.");
		}
	}

}
