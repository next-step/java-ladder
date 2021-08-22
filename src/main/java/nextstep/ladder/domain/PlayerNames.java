package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class PlayerNames {

	private static final String DELIMITER = ",";

	private final List<String> names;

	public PlayerNames(String names) {
		this.names = splitByDelimiter(names);
	}

	public int size() {
		return names.size();
	}

	private List<String> splitByDelimiter(String names) {
		List<String> playerNames = new ArrayList<>();
		String[] namesArray = names.split(DELIMITER);
		Collections.addAll(playerNames, namesArray);
		return playerNames;
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
