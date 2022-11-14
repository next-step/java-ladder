package step2.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Users {
	private static final String DELIMITER = ",";
	private final List<User> users;

	public Users(List<User> users) {
		this.users = users;
	}

	public Users(String inputUsers) {
		this(Arrays.stream(inputUsers.split(DELIMITER))
				.map(User::new)
				.collect(Collectors.toList()));
	}

	public int getUsersCnt() {
		return users.size();
	}

	public List<User> getUsers() {
		return users;
	}
}
