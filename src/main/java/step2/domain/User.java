package step2.domain;

import java.util.Objects;

public class User implements Comparable<User> {
	private final String name;

	public User(String name) {
		validUserName(name);
		this.name = name;
	}

	private void validUserName(String name) {
		if (name.length() > 5) {
			throw new IllegalArgumentException("참여자 이름은 최대 5자 까지 입력 가능합니다.");
		}
	}

	@Override
	public int compareTo(User user) {
		return this.name.compareTo(user.name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;

		User user = (User) obj;

		return Objects.equals(name, user.name);
	}

	@Override
	public int hashCode() {
		return name != null ? name.hashCode() : 0;
	}

	@Override
	public String toString() {
		return name;
	}
}
