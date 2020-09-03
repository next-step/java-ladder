package step2.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Game {

	public void gameStart(String[] names, int height) {
		List<User> users = Arrays.stream(names)
				.map(User::new)
				.collect(Collectors.toList());

		Ladders ladders = Ladders.createLadders(users);
	}
}
