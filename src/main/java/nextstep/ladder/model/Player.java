package nextstep.ladder.model;

public class Player {
	private final static int MAX_NAME_LENGTH = 5;
	private final String name;

	public Player(final String name) {
		validate(name);
		this.name = name;
	}

	private void validate(final String name) {
		if (name.length() > MAX_NAME_LENGTH) {
			throw new IllegalArgumentException("사용자의 이름은 5자를 넘을 수 없습니다");
		}
	}

	@Override
	public String toString() {
		return String.format("%6s", name);
	}
}
