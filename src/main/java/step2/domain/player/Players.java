package step2.domain.player;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import step2.util.ErrorTarget;
import step2.util.Validator;

public class Players {

	private static final String DELIMITER = ",";
	private static final int MIN_COUNT = 2;

	private final Set<Player> values = new HashSet<>();

	public Players(String input) {
		Validator.notBlank(input, ErrorTarget.NAME_INPUT);

		String[] split = input.split(DELIMITER);
		Set<Player> players = Stream.of(split)
			.map(Player::new)
			.collect(Collectors.toSet());

		int setSize = players.size();
		Validator.equivalent(split.length, setSize, String.format("입력 값에 중복이 존재합니다. 입력 : %s", input));
		Validator.min(MIN_COUNT, setSize, String.format("플레이어의 최소 숫자는 %d 입니다. 입력 : %d", MIN_COUNT, setSize));

		values.addAll(players);
	}

	public int numberOfPlayer() {
		return this.values.size();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Players players = (Players)o;
		return Objects.equals(values, players.values);
	}

	@Override
	public int hashCode() {
		return Objects.hash(values);
	}

	@Override
	public String toString() {
		return values.stream()
			.map(player -> String.format("%-5s", player.toString()))
			.sorted(String::compareToIgnoreCase)
			.collect(Collectors.joining());
	}
}
