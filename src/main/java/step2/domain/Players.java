package step2.domain;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import step2.util.Validator;

public class Players {

	private static final String DELIMITER = ",";
	private static final int MIN_COUNT = 2;

	private final Set<Player> values = new HashSet<>();

	public Players(String input) {
		Validator.notBlank(input);

		String[] split = input.split(DELIMITER);
		Set<Player> players = Stream.of(split)
			.map(Player::new)
			.collect(Collectors.toSet());

		validateDuplication(split.length, players.size());
		validateMinCount(players.size());

		values.addAll(players);
	}

	private void validateDuplication(int inputSize, int setSize) {
		if (inputSize != setSize) {
			throw new IllegalArgumentException("입력 값에 중복된 이름이 있습니다.");
		}
	}

	private void validateMinCount(int size) {
		if (size < MIN_COUNT) {
			throw new IllegalArgumentException("플레이어는 최소 두 명이어야 합니다.");
		}
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
