package laddergame.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PlayerGenerator {

	public static List<Player> generate(String rawPlayers) {
		return Arrays.stream(rawPlayers.split("[, ]+"))
				.map(Player::new)
				.collect(Collectors.toList());
	}
}
