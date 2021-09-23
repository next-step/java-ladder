package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import nextstep.ladder.exception.MinimumPlayersException;

public class Players {
	private static final String COMMA = ",";
	private static final int MINIMUM_PLAYERS = 2;
	private static final String MINIMUM_PLAYERS_EXCEPTION_MESSAGE = "게임에 참가하려면 최소 2인 이상이어야 합니다.";

	private final List<Player> players;

	public Players(String inputNames) {
		List<Player> players = Arrays.stream(inputNames.split(COMMA))
			.map(inputName -> new Player(inputName.trim()))
			.collect(Collectors.toList());
		checkMinimumPlayers(players);
		this.players = players;
	}

	public int count() {
		return players.size();
	}

	private void checkMinimumPlayers(List<Player> players) {
		if (players.size() < MINIMUM_PLAYERS) {
			throw new MinimumPlayersException(MINIMUM_PLAYERS_EXCEPTION_MESSAGE);
		}
	}

	public List<Player> getPlayers() {
		return players;
	}
}
