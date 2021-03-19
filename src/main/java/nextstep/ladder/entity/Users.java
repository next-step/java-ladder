package nextstep.ladder.entity;

import static nextstep.ladder.exception.UserExceptionMesssage.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import nextstep.ladder.exception.UserException;

public class Users {
	private static final String DELIMETER = ",";
	private final List<User> users;

	public Users(List<User> users) {
		this.users = users;
	}

	public Users(String userNames) {
		validate(userNames);

		String[] userNameArray = userNames.split(DELIMETER);
		this.users = IntStream.range(0, userNameArray.length)
			.mapToObj((i) -> new User(userNameArray[i], i))
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

	public int getUserCount() {
		return this.users.size();
	}

	@Override
	public String toString() {
		return users.stream()
			.map(User::toString)
			.collect(Collectors.joining("  "));
	}
}
