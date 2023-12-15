package nextstep.ladder.domain;

import java.util.Objects;

public class User {
	private static final int MAX_LENGTH = 5;
	private final String name;

	public User(String name) {
		this.name = name;
		validUser();
	}

	public String value() {
		return name;
	}

	private void validUser() {
		isNotBlank();
		isUnderMaxLength();
	}

	private void isNotBlank() {
		if (name.isBlank()) {
			throw new IllegalArgumentException("이름은 공백일 수 없습니다.");
		}
	}

	private void isUnderMaxLength() {
		if (name.length() > MAX_LENGTH) {
			throw new IllegalArgumentException("사용자 이름의 최대길이는 " + MAX_LENGTH + "를 넘을 수 없습니다.");
		}
	}

	public boolean equalName(String name) {
		return this.name.equals(name);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		User user = (User)o;
		return Objects.equals(name, user.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}
