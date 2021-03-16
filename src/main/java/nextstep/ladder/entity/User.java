package nextstep.ladder.entity;

import static nextstep.ladder.exception.UserExceptionMesssage.*;

import java.util.Optional;

import nextstep.ladder.exception.UserException;

public class User {
	private final String name;

	public User(String name) {
		validateName(name);
		this.name = name;
	}

	private void validateName(String name) {
		if (Optional.ofNullable(name).orElse("").length() > 5) {
			throw new UserException(NAME_SIZE_CHECK_FIVE);
		}
	}

	@Override
	public String toString() {
		return this.name;
	}
}
