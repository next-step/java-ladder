package nextstep.ladder.domain;

public class Reward extends LadderItem {

	public Reward(String name, Position position) {
		super(name, position);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
