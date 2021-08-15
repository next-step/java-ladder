package ladder.domain;

import ladder.utils.StringUtil;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Players {

	private static final String NAME_DELIMITER = ",";
	private static final int MIN_SIZE = 2;

	private final List<Player> players;

	public Players(List<Player> players) {
		validatePlayersSize(players);
		this.players = players;
	}

	public static Players of(String playersName) {
		validatePlayersName(playersName);
		return Arrays.stream(playersName.split(NAME_DELIMITER))
		             .map(Player::new)
		             .collect(collectingAndThen(toList(), Players::new));
	}

	private static void validatePlayersSize(List<Player> players) {
		if (players.isEmpty() || players.size() < MIN_SIZE) {
			throw new PlayersSizeException();
		}
	}

	private static void validatePlayersName(String playersName) {
		if (StringUtil.isBlank(playersName)) {
			throw new PlayerNameException();
		}
	}

	public int size() {
		return players.size();
	}

}
