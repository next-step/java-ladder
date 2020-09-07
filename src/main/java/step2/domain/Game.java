package step2.domain;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Game {
	private final Ladder ladder;

	public Game(String[] names) {
		this.ladder = new Ladder(new Users(
				Arrays.stream(names)
						.map(User::new)
						.collect(Collectors.toList()))
		);
	}
	
	public Ladder start(int height) {
		return ladder.makeLadder(height);
	}
}
