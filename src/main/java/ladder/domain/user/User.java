package ladder.domain.user;

import java.util.Objects;

public class User {
	private static final int NAME_LENGTH_MAX_NUMBER = 5;
	private final String name;

	public User(String name) {
		this.name = name;
	}

	public static User createUser(String name) {
		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException("이름은 null이나 빈 문자열이 될 수 없습니다.");
		}
		if (name.length() > NAME_LENGTH_MAX_NUMBER) {
			throw new IllegalArgumentException("이름은 5자 이하여야 합니다.");
		}
		return new User(name);
	}

	public String getName() {
		return name;
	}

	public String getNameWithSpace() {
		return String.format("%-" + 6 + "s", name);
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
		return Objects.hash(name);
	}

    public boolean isMatchUser(String matchUser) {
		return name.equals(matchUser);
    }
}
