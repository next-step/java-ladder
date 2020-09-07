package step2.domain;

public class Game {
	private final Ladder ladder;

	public Game(String[] names) {
		this.ladder = new Ladder(new Users(names));
	}
	
	public Ladder start(int height) {
		return ladder.makeLadder(height);
	}
}
