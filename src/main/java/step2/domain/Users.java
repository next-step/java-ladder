package step2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Users {
	private final List<User> users;

	public Users(List<User> users) {
		this.users = new ArrayList<>(users);
	}

	public List<User> getUsers() {
		return Collections.unmodifiableList(this.users);
	}

	public int size() {
		return this.users.size();
	}
}
