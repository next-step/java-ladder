package nextstep.ladder.domain;

public class Participant extends LadderItem {
	public static final int MAX_SIZE = 5;

	public Participant(String name) {
		this(name, new Position(0));
	}

	public Participant(String name, Position position) {
		super(name, position);
		validate(name);
	}

	private void validate(String name) {
		if (name.length() > MAX_SIZE) {
			throw new IllegalArgumentException(name + "은 5자를 넘습니다.");
		}
	}

	public void move(Direction direction) {
		this.position = direction.apply(this.position);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
