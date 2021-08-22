package nextstep.ladder.domain;

import java.util.Objects;

import nextstep.ladder.exception.InvalidNameLengthException;

public class PlayerName {

	private static final int MIN_LENGTH = 1;
	private static final int MAX_LENGTH = 5;

	private final String name;

	public PlayerName(String name) {
		validateNameLength(name);
		this.name = name;
	}

	private void validateNameLength(String name) {
		int currentNameLength = name.length();
		if (currentNameLength < MIN_LENGTH || currentNameLength > MAX_LENGTH) {
			throw new InvalidNameLengthException(currentNameLength);
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		PlayerName that = (PlayerName)o;
		return Objects.equals(name, that.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}
