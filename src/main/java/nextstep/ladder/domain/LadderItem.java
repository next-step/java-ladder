package nextstep.ladder.domain;

public class LadderItem {
	protected final String name;
	protected Position position;

	public LadderItem(String name, Position position) {
		this.name = name;
		this.position = position;
	}

	public String name() {
		return this.name;
	}

	public Position position() {
		return this.position;
	}

	public boolean match(Position position) {
		return this.position.equals(position);
	}
}
