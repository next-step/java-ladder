package step2.domain.ladder;

public enum Direction {
	LEFT("--|  "),
	STRAIGHT("  |  "),
	RIGHT("  |--");

	private final String content;

	Direction(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return this.content;
	}
}
