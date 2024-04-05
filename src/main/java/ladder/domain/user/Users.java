package ladder.domain.user;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Users {
	private final List<User> users;

	public Users(String usersString) {
		List<User> users = Arrays.stream(usersString.split(","))
				.map(String::trim)
				.map(User::new)
				.collect(Collectors.toList());
		if(users.size() != users.stream().map(user -> user.getName()).distinct().count()){
			throw new IllegalArgumentException("유저이름은 중복될 수 없습니다.");
		}
		this.users = users;
	}

	public Users(List<User> users) {
		this.users = users;
	}

	public static Users createUsers(String usersString) {
		return new Users(usersString);
	}

	public List<User> getUsers() {
		return users;
	}

	public int getCountOfPerson() {
		return users.size();
	}
}
