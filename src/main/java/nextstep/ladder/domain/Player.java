package nextstep.ladder.domain;

public class Player {
	private final Name name;

	public Player(String name) {
		this.name = new Name(name);
	}

	@Override
	public String toString() {
		return name.toString();
	}
}
