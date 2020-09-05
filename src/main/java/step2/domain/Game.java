package step2.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Game {
	private final List<User> users;

	public Game(String[] names) {
		this.users = Arrays.stream(names)
				.map(User::new)
				.collect(Collectors.toList());
	}
	
	public Ladder start(int height) {
		return Ladder.makeLadder(users, height);
	}
}
