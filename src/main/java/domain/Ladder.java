package domain;

public enum Ladder {

	VERTICAL("|"),
	NOT_IS_WIDTH("     "),
	IS_WIDTH("-----");

	private String ladder;

	Ladder(String ladder) {
		this.ladder = ladder;
	}

	public String view() {
		return this.ladder;
	}
}
