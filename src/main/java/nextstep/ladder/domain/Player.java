package nextstep.ladder.domain;

public class Player {
	private final Name name;

	public Player(Name name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name.toString();
	}
}
