package study2.domain;

public class Player {

	private String name;
	private static final String NAME_LIMIT = "이름은 최대 5글자 입니다.";
	private static final String LEAST_NAME_LIMIT = "이름은 최소 1글자 이상, 공백은 불가능합니다.";
	private static final String NAME_IS_NULL = "이름이 널입니다.";
	
	public Player(String name) {
		nameLimiation(name);
		this.name = name;
	}

	private void nameLimiation(String name) {

		if (name.length() > 5) {
			throw new IllegalArgumentException(NAME_LIMIT);
		}

		if ("".equals(name) || " ".equals(name)) {
			throw new IllegalArgumentException(LEAST_NAME_LIMIT);
		}
		if(name == null) {
			throw new NullPointerException(NAME_IS_NULL);
		}
	}

	public String getPlayerName() {
		return name;
	}
}
