package step2.domain.player;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import step2.util.ErrorTarget;
import step2.util.Validator;

public class Players {

	private static final int MIN_COUNT = 2;

	private final Set<Player> values;

	public Players(List<String> input) {
		Validator.notNull(input, ErrorTarget.NAME_INPUT);
		Validator.duplicate(input, String.format("입력 값에 중복이 존재합니다. 입력 : %s", input));
		Validator.min(MIN_COUNT, input.size(), String.format("플레이어의 최소 숫자는 %d 입니다. 입력 : %d", MIN_COUNT, input.size()));

		this.values = input.stream()
			.map(Player::new)
			.collect(Collectors.toSet());
	}

	public int numberOfPlayer() {
		return this.values.size();
	}

	public Set<Player> getValues() {
		return values;
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
}
