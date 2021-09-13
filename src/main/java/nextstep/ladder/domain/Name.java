package nextstep.ladder.domain;

import nextstep.ladder.exception.NameLengthException;

public class Name {
	private static final int MAX_LENGTH = 5;
	private final String name;

	public Name(String name) {
		checkLength(name);
		this.name = name;
	}

	private void checkLength(String name) {
		if (name.length() > MAX_LENGTH) {
			throw new NameLengthException(String.format("이름은 최대 5글자 입니다. (이름: %s)", name));
		}
		if (name.isEmpty()) {
			throw new NameLengthException(String.format("이름은 최소 1글자 이상이어야 합니다. (이름: %s)", name));
		}
	}
}
