package ladder.domain;

import java.util.Objects;

public class Player {

	private static final int LIMIT_LENGTH = 5;

	private final String name;

	public Player(String name) {
		if (name.isEmpty() || name.length() > LIMIT_LENGTH) {
			throw new PlayerNameException();
		}
		this.name = name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Player player = (Player) o;
		return Objects.equals(name, player.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public String toString() {
		return name;
	}

}
