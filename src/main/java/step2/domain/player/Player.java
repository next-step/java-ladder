package step2.domain.player;

import java.util.Objects;

public class Player {

	private final Name name;

	public Player(String input) {
		this.name = new Name(input);
	}

	public String getName() {
		return name.getValue();
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
