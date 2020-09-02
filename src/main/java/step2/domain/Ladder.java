package step2.domain;

public class Ladder {
	private final User user;
	private final boolean[] ladder;

	public Ladder(String name, int ladderHeight) {
		this.user = new User(name);
		this.ladder = new boolean[ladderHeight];
	}



}
