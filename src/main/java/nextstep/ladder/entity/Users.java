package nextstep.ladder.entity;

import static nextstep.ladder.exception.UserExceptionMesssage.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import nextstep.ladder.exception.UserException;

public class Users {
	private final List<User> users;
	private static final String DELIMETER = ",";

	public Users(String userNames) {
		validate(userNames);
		this.users = Arrays.stream(userNames.split(DELIMETER))
			.map(User::new)
			.collect(Collectors.toList());
	}

	private void validate(String userNames) {
		if (!userNames.contains(DELIMETER)) {
			throw new UserException(DELIMETER_WITHIN_COMMA);
		}
	}

	public List<User> getUsers() {
		return users;
	}

	@Override
	public String toString() {
		return users.stream()
			.map(User::toString)
			.collect(Collectors.joining("  "));
	}
}
