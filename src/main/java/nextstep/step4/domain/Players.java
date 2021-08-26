package nextstep.step4.domain;

import static java.util.stream.Collectors.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Players {

	private static final String DELIMITER = ",";

	private final List<Player> players;

	public Players(List<Player> players) {
		this.players = new ArrayList<>(players);
	}

	public static Players from(String names) {
		List<Player> players = Arrays.stream(names.split(DELIMITER))
								.map(Player::new)
								.collect(collectingAndThen(toList(), Collections::unmodifiableList));
		return new Players(players);
	}

	public Player of(int position) {
		return players.get(position);
	}

	public int size() {
		return players.size();
	}

	public List<String> names() {
		return players.stream()
				.map(Player::name)
				.collect(collectingAndThen(toList(), Collections::unmodifiableList));
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
