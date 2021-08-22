package nextstep.ladder.domain;

import java.util.Objects;

public class PlayerNames {

	private final String names;

	public PlayerNames(String names) {
		this.names = names;
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
