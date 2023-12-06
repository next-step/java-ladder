package nextstep.ladder.domain;

public class User {
	private static final int MAX_LENGTH = 5;
	private final String name;

	public User(String name) {
		this.name = name;
		validUser();
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
}
