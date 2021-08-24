package nextstep.ladder.domain;

import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Players {

	private static final String DELIMITER = ",";

	private final List<Player> players;

	private Players(List<Player> players) {
		this.players = players;
	}

	public static Players from(String names) {
		List<Player> players = Arrays.stream(names.split(DELIMITER))
								.map(Player::new)
								.collect(collectingAndThen(toList(), Collections::unmodifiableList));
		return new Players(players);
	}

	public int size() {
		return players.size();
	}

	public List<Player> values() {
		return Collections.unmodifiableList(players);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Players that = (Players)o;
		return Objects.equals(players, that.players);
	}

	@Override
	public int hashCode() {
		return Objects.hash(players);
	}
}
