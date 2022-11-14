package step2.model;

public class User {
	private static final int MAX_LENGTH = 5;
	private final String name;

	public User(String name) {
		checkNameStatus(name);
		this.name = name;
	}

	private void checkNameStatus(String name) {
		if (name.length() > MAX_LENGTH) {
			throw new IllegalArgumentException("이름의 길이는 최대 5글자입니다.");
		}
	}

	public String getName() {
		return name;
	}
}
