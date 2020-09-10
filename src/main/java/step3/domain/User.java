package step3.domain;

import java.util.Objects;

public class User {
	private final static int MAX_NAME_LENGTH = 5;

	private final String name;

	public User(String name) {
		validUserName(name);
		this.name = name;
	}

	private void validUserName(String name) {
		if (name.length() > MAX_NAME_LENGTH) {
			throw new IllegalArgumentException("참여자 이름은 최대 5자 까지 입력 가능합니다.");
		}
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		User user = (User) o;

		return Objects.equals(name, user.name);
	}

	@Override
	public int hashCode() {
		return name != null ? name.hashCode() : 0;
	}
}
