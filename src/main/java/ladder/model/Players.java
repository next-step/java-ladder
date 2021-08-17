package ladder.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import ladder.message.ErrorMessage;

public class Players {

	private static final String NAME_REGEX = ",";
	private final List<Player> players;

	public Players(String playersName) {
		checkEmptyName(playersName);
		this.players = Collections.unmodifiableList(toList(playersName));
	}

	public List<Player> getPlayers() {
		return players;
	}

	public int findPlayerCount() {
		return players.size();
	}

	public int findPlayerPosition(Player player) {
		return players.indexOf(player);
	}

	private List<Player> toList(String playersName) {
		return Arrays.stream(playersName.split(NAME_REGEX))
			.map(name -> new Player(new Name(name)))
			.collect(Collectors.toCollection(LinkedList::new));
	}

	private void checkEmptyName(String playersName) {
		if (playersName.isEmpty()) {
			throw new IllegalArgumentException(ErrorMessage.EMPTY_ERROR_MESSAGE);
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Players players1 = (Players)o;
		return Objects.equals(players, players1.players);
	}

	@Override
	public int hashCode() {
		return Objects.hash(players);
	}
}
