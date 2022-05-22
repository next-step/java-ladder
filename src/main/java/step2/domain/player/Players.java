package step2.domain.player;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import step2.util.ErrorTarget;
import step2.util.Validator;

public class Players {

	private static final int MIN_INDEX = 0;
	private static final int MIN_COUNT = 2;

	private final List<Player> values;

	public Players(List<String> names) {
		Validator.notNull(names, ErrorTarget.NAME_INPUT);
		Validator.duplicate(names, String.format("입력 값에 중복이 존재합니다. 입력 : %s", names));
		Validator.min(MIN_COUNT, names.size(), String.format("플레이어의 최소 숫자는 %d 입니다. 입력 : %d", MIN_COUNT, names.size()));

		this.values = names.stream()
			.map(Player::new)
			.collect(Collectors.toList());
	}

	public int numberOfPlayer() {
		return this.values.size();
	}

	public int findIndexByName(String playerName) {
		Validator.notBlank(playerName, ErrorTarget.NAME_INPUT);
		Player result = this.values.stream()
			.filter(player -> player.hasName(playerName))
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException(String.format("입력한 플레이어는 존재하지 않습니다. 입력 : %s", playerName)));
		return values.indexOf(result);
	}

	public String findPlayerNameByIndex(int index) {
		Validator.min(MIN_INDEX, index, String.format("플레이어의 출발 인덱스가 최솟값(%d)보다 작습니다. 입력 : %d", MIN_INDEX, index));
		Validator.max(values.size() - 1, index,
			String.format("플레이어의 출발 인덱스가 최댓값(%d)보다 큽니다. 입력 : %d", values.size() - 1, index));
		return values.get(index).getName();
	}

	public List<Player> getValues() {
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
