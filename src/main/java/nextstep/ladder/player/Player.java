package nextstep.ladder.player;

import java.util.Objects;

public class Player {

	private static final int MAXIMUM_NAME_LENGTH = 5;
	private String name;

	private Player(String name) {
		this.name = name;
	}

	public static Player ofName(String name) {
		validateNotNull(name);
		validateNameLength(name);
		return new Player(name);
	}

	private static void validateNotNull(String name) {
		if (Objects.isNull(name) || name.trim().isEmpty()) {
			throw new IllegalArgumentException("이름은 null 또는 빈 공백일 수 없습니다.");
		}
	}

	private static void validateNameLength(String name) {
		if (name.length() > MAXIMUM_NAME_LENGTH) {
			throw new IllegalArgumentException("이름의 최대 길이는 5자입니다.");
		}
	}

	public String getName() {
		return name;
	}
}
