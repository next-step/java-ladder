package nextstep.step4.domain;

import java.util.Objects;

import nextstep.step4.exception.InvalidNameLengthException;

public class Player {

	private static final int MIN_LENGTH = 1;
	private static final int MAX_LENGTH = 5;

	private final String name;

	public Player(String name) {
		validateNameLength(name);
		this.name = name;
	}

	public String name() {
		return name;
	}

	private void validateNameLength(String name) {
		int length = name.length();
		if (length < MIN_LENGTH || length > MAX_LENGTH) {
			throw new InvalidNameLengthException(length);
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Player player = (Player)o;
		return Objects.equals(name, player.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}
