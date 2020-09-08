package step3.domain;

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
}
