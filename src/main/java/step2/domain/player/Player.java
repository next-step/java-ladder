package step2.domain.player;

import java.util.Objects;

import step2.util.ErrorTarget;
import step2.util.Validator;

public class Player {

	private static final int MAX_NAME_LENGTH = 5;

	private final String name;

	public Player(String input) {
		Validator.notBlank(input, ErrorTarget.NAME_INPUT);
		Validator.max(MAX_NAME_LENGTH, input.length(),
			String.format("이름이 최대 길이는 %d 글자 입니다. 입력 : %s", MAX_NAME_LENGTH, input));

		this.name = input;
	}

	public boolean hasName(String playerName) {
		return this.name.equals(playerName);
	}

	public String getName() {
		return name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Player player = (Player)o;
		return Objects.equals(name, player.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}
