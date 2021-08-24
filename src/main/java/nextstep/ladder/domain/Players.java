package nextstep.ladder.domain;

import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Players {

	private static final String DELIMITER = ",";

	private final List<Player> players;

	public Players(String names) {
		this.players = createPlayers(names);
	}

	public int size() {
		return players.size();
	}

	public List<Player> values() {
		return Collections.unmodifiableList(players);
	}

	private List<Player> createPlayers(String names) {
		String[] nameArray = names.split(DELIMITER);
		return Arrays.stream(nameArray)
				.map(Player::new)
				.collect(collectingAndThen(toList(), Collections::unmodifiableList));
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
