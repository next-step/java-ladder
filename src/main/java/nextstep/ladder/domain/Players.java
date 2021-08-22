package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Players {

	private static final String DELIMITER = ",";

	private final List<Player> names;

	public Players(String names) {
		this.names = createPlayers(names);
	}

	public int size() {
		return names.size();
	}

	private List<Player> createPlayers(String names) {
		String[] nameArray = names.split(DELIMITER);
		return Arrays.stream(nameArray)
				.map(Player::new)
				.collect(Collectors.toList());
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Players that = (Players)o;
		return Objects.equals(names, that.names);
	}

	@Override
	public int hashCode() {
		return Objects.hash(names);
	}
}
