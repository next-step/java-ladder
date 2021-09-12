package domain;

import java.util.ArrayList;
import java.util.List;

public class Users {

	private List<User> users;

	public Users(List<User> users) {
		this.users = new ArrayList<>(users);
	}

	public Integer count() {
		return users.size();
	}

	@Override
	public String toString() {
		return String.valueOf(users);
	}
}
