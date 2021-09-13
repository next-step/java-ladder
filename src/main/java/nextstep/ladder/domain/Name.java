package nextstep.ladder.domain;

import nextstep.ladder.exception.NameLengthException;

public class Name {
	private static final int MAX_LENGTH = 5;
	private static final String NAME_MAX_LENGTH_EXCEPTION_MESSAGE = "이름은 최대 5글자 입니다. (이름: %s)";
	private static final String NAME_MIN_LENGTH_EXCEPTION_MESSAGE = "이름은 최소 1글자 입니다. (이름: %s)";

	private final String name;

	public Name(String name) {
		checkLength(name);
		this.name = name;
	}

	private void checkLength(String name) {
		if (name.length() > MAX_LENGTH) {
			throw new NameLengthException(String.format(NAME_MAX_LENGTH_EXCEPTION_MESSAGE, name));
		}
		if (name.isEmpty()) {
			throw new NameLengthException(String.format(NAME_MIN_LENGTH_EXCEPTION_MESSAGE, name));
		}
	}
}
