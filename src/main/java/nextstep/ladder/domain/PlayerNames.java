package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class PlayerNames {

	private static final String DELIMITER = ",";

	private final List<PlayerName> names;

	public PlayerNames(String names) {
		this.names = createPlayerNames(names);
	}

	public int size() {
		return names.size();
	}

	private List<PlayerName> createPlayerNames(String names) {
		String[] nameArray = names.split(DELIMITER);
		return Arrays.stream(nameArray)
				.map(PlayerName::new)
				.collect(Collectors.toList());
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		PlayerNames that = (PlayerNames)o;
		return Objects.equals(names, that.names);
	}

	@Override
	public int hashCode() {
		return Objects.hash(names);
	}
}
